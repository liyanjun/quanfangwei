package org.li.module.system.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.li.common.util.*;
import org.li.common.util.aliyun.MSMUtil;
import org.li.common.util.lingling.LingLingSDK;
import org.li.common.vo.Result;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.lingling.bean.SvOwner;
import org.li.module.lingling.bean.SysUser;
import org.li.module.lingling.service.SvOwnerService;
import org.li.module.system.bean.SystemRole;
import org.li.module.system.bean.SystemUser;
import org.li.module.system.bean.vo.LoginResponseVO;
import org.li.module.system.service.SystemUserService;
import org.li.module.user.bean.SvDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    Logger logger = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private SystemUserService userService;
    @Autowired
    private SvOwnerService svOwnerService;

    @ResponseBody
    @RequestMapping("getVerificationCode")
    @ApiOperation(value = "获取验证码", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "根据手机号获取验证码")
    public Result getVerificationCode(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone) {
        if (!RegexUtil.isPhone(phone)) {
            return Result.fail("请输入正确的手机号码。");
        }
        String captcha = GenerateUtil.geneCaptcha();
//        MSMUtil.sendCaptchaMSM(captcha);
        EHCacheUtil.getInstance().put(EHCacheUtil.CAPTCHA_CACHE, phone, captcha);
        return Result.success("获取验证码成功", captcha);
    }

    @ResponseBody
    @RequestMapping("register")
    @ApiOperation(value = "用户注册", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "用户注册")
    public Result register(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone,
                           @ApiParam(required = true, name = "code", value = "验证码") @RequestParam String code,
                           @ApiParam(required = true, name = "password", value = "用户输入密码") @RequestParam String password,
                           @ApiParam(required = true, name = "passwordRepeat", value = "用户输入重复的密码") @RequestParam String passwordRepeat) {
        Integer roleId = 1;
        SystemUser isExist = userService.findByPhone(phone);
        if (isExist != null) {
            return Result.fail("该手机号码已注册。");
        }
        Result result = validate(phone, code, password, passwordRepeat);
        if (result != null) {
            return result;
        }
        SystemUser systemUser = new SystemUser(phone, CryptographyUtil.md5(password));
        SvOwner svOwner = svOwnerService.findLingLingUserInfo(phone);
        SysUser sysUser = svOwnerService.findLingLingManagerInfo(phone);
        if (svOwner == null && sysUser == null) {
            // 访客用户
            roleId = 1;
        }

        if (svOwner != null) {
            roleId = 2;
            systemUser.setValue(svOwner);
        }

        if (sysUser != null) {
            roleId = 3;
            systemUser.setAdminValue(sysUser);
            // 获取一个令令ID
            if(StringUtils.isEmpty(systemUser.getLinglingId())){
                String linglingId = LingLingSDK.getLingLingId();
                systemUser.setLinglingId(linglingId);
            }
        }
        userService.insertSystemUser(systemUser, roleId);
        // 验证码已使用，删除掉它
        EHCacheUtil.getInstance().remove(EHCacheUtil.CAPTCHA_CACHE, phone);
        //生成token
        String token = CryptographyUtil.getToken(phone, password);
        systemUser.setPassword("");
        EHCacheUtil.getInstance().put(EHCacheUtil.LOGIN_CACHE, token, systemUser);
        EHCacheUtil.getInstance().put(EHCacheUtil.LOGIN_CACHE, phone, token);
        return Result.success("用户注册成功", LoginResponseVO.build(systemUser, token));
    }

    @ResponseBody
    @RequestMapping("login")
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "用户登录")
    public Result login(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone,
                        @ApiParam(required = true, name = "password", value = "密码") @RequestParam String password) {
        SystemUser systemUser = userService.findByPhone(phone);
        if (systemUser == null) {
            return Result.fail("账号密码错误");
        }
        if (StringUtils.isEmpty(password)) {
            return Result.fail("账号密码错误");
        }
        if (!CryptographyUtil.md5(password).equals(systemUser.getPassword())) {
            return Result.fail("账号密码错误");
        }
        SvOwner svOwner = svOwnerService.findLingLingUserInfo(phone);
        SysUser sysUser = svOwnerService.findLingLingManagerInfo(phone);
        if (svOwner == null && sysUser == null && systemUser.getRoleId().intValue() != 1) {
            // 角色改变成访客
            systemUser.setRoleId(1);
        }
        if (svOwner != null && systemUser.getRoleId().intValue() != 2) {
            // 角色改变成用户
            systemUser.setRoleId(2);
            systemUser.setValue(svOwner);
        }
        if (sysUser != null && systemUser.getRoleId().intValue() != 3) {
            // 角色改变成管理员
            systemUser.setRoleId(3);
            systemUser.setAdminValue(sysUser);
            if(StringUtils.isEmpty(systemUser.getLinglingId())){
                String linglingId = LingLingSDK.getLingLingId();
                systemUser.setLinglingId(linglingId);
            }
        }
        //TODO 修改update,同时updateRoleId
//        userService.updateSystemUser(systemUser);
        String token = CryptographyUtil.getToken(phone, password);
        Object oldToken = EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, phone);
        if (oldToken != null) {
            //之前存在有效登陆的，清理掉
            EHCacheUtil.getInstance().remove(EHCacheUtil.LOGIN_CACHE, phone);
            EHCacheUtil.getInstance().remove(EHCacheUtil.LOGIN_CACHE, oldToken);
        }

        EHCacheUtil.getInstance().put(EHCacheUtil.LOGIN_CACHE, token, systemUser);
        EHCacheUtil.getInstance().put(EHCacheUtil.LOGIN_CACHE, phone, token);
        systemUser.setPassword("");
        return Result.success("用户登陆成功", LoginResponseVO.build(systemUser, token));
    }

    @ResponseBody
    @RequestMapping("findPassword")
    @ApiOperation(value = "找回密码", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "找回密码")
    public Result findPassword(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone,
                               @ApiParam(required = true, name = "code", value = "验证码") @RequestParam String code,
                               @ApiParam(required = true, name = "password", value = "用户输入密码") @RequestParam String password,
                               @ApiParam(required = true, name = "passwordRepeat", value = "用户输入重复的密码") @RequestParam String passwordRepeat) {
        Result result = validate(phone, code, password, passwordRepeat);
        if (result != null) {
            return result;
        }
        SystemUser systemUser = userService.findByPhone(phone);
        if(systemUser == null){
            return Result.fail("账号不存在");
        }
        systemUser.setPassword(CryptographyUtil.md5(password));
        userService.updateSystemUser(systemUser);
        // 验证码已使用，删除掉它
        EHCacheUtil.getInstance().remove(EHCacheUtil.CAPTCHA_CACHE, phone);
        return Result.success("密码已重新设置");
    }

    @ResponseBody
    @RequestMapping("editPassword")
    @ApiOperation(value = "修改密码", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "修改密码")
    public Result editPassword(@ApiParam(required = true, name = "token", value = "") @RequestParam String token,
                               @ApiParam(required = true, name = "oldPassword", value = "旧密码") @RequestParam String oldPassword,
                               @ApiParam(required = true, name = "password", value = "用户输入密码") @RequestParam String password,
                               @ApiParam(required = true, name = "passwordRepeat", value = "用户输入重复的密码") @RequestParam String passwordRepeat) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        if (systemUser == null) {
            return Result.fail("请登录后修改密码");
        }
        SystemUser user = userService.findByPhone(systemUser.getPhone());
        if (!user.getPassword().equals(CryptographyUtil.md5(oldPassword))) {
            return Result.fail("旧密码不正确。");
        }
        Result result = validatePassword(password, passwordRepeat);
        if (result != null) {
            return result;
        }
        user.setPassword(CryptographyUtil.md5(password));
        userService.updateSystemUser(user);
        return Result.success("密码已修改");
    }

    @ResponseBody
    @RequestMapping("logout")
    @ApiOperation(value = "登出", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "登出")
    public Result logout(@ApiParam(required = true, name = "token", value = "") @RequestParam String token,
                         @ApiParam(required = true, name = "phone", value = "手机号") @RequestParam String phone) {

        EHCacheUtil.getInstance().remove(EHCacheUtil.LOGIN_CACHE, phone);
        EHCacheUtil.getInstance().remove(EHCacheUtil.LOGIN_CACHE, token);
        return Result.success("成功登出");
    }

    /**
     * 注册或者找回密码时验证
     *
     * @param phone
     * @param code
     * @param password
     * @param passwordRepeat
     * @return
     */
    private Result validate(String phone, String code, String password, String passwordRepeat) {
        if (!RegexUtil.isPhone(phone)) {
            return Result.fail("请输入正确的手机号码。");
        }
        Object captcha = EHCacheUtil.getInstance().get(EHCacheUtil.CAPTCHA_CACHE, phone);
        if (captcha == null || code == null || !captcha.equals(code)) {
            return Result.fail("验证码不正确。");
        }
        return validatePassword(password, passwordRepeat);
    }

    /**
     * 密码验证
     *
     * @param password
     * @param passwordRepeat
     * @return
     */
    private Result validatePassword(String password, String passwordRepeat) {
        if (password == null || passwordRepeat == null || !password.equals(passwordRepeat)) {
            return Result.fail("两次密码输入不一致。");
        }
        if (password.length() < 6 || passwordRepeat.length() < 6) {
            return Result.fail("请输入六位以上密码。");
        }
        return null;
    }


}
