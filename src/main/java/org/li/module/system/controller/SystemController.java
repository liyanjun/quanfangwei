package org.li.module.system.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.li.common.util.*;
import org.li.common.util.lingling.LingLingSDK;
import org.li.common.vo.Result;
import org.li.module.lingling.bean.SvOwner;
import org.li.module.lingling.service.SvOwnerService;
import org.li.module.system.bean.SystemUser;
import org.li.module.system.service.SystemUserService;
import org.li.module.user.bean.SvDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        // TODO 验证手机号是否合法
        String captcha = GenerateUtil.geneCaptcha();
        // TODO 调用短信发送接口
        EHCacheUtil.getInstance().put(EHCacheUtil.CAPTCHA_CACHE,phone,captcha);
        return Result.success("获取验证码成功");
    }

    @ResponseBody
    @RequestMapping("register")
    @ApiOperation(value = "用户注册", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "用户注册")
    public Result register(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone,
                           @ApiParam(required = true, name = "code", value = "验证码") @RequestParam String code,
                           @ApiParam(required = true, name = "password", value = "用户输入密码") @RequestParam String password,
                           @ApiParam(required = true, name = "passwordRepeat", value = "用户输入重复的密码") @RequestParam String passwordRepeat) {
        if(!RegexUtil.isPhone(phone)){
            return Result.fail("请输入正确的手机号码。");
        }
        String captcha = EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE,phone).toString();
        if(captcha==null || code == null || !captcha.equals(code)){
            return Result.fail("验证码不正确。");
        }
        if(password==null || passwordRepeat == null || !password.equals(passwordRepeat)){
            return Result.fail("两次密码输入不一致。");
        }
        SystemUser systemUser = new SystemUser(phone,password);
        SvOwner svOwner = svOwnerService.findLingLingUserInfo(phone);
        if(svOwner == null){
            // 访客用户
            return  Result.success("用户注册成功",systemUser);
        }
        systemUser.setValue(svOwner);
        List<SvDevice> devices = svOwnerService.findUserDevices(systemUser.getOwnerId());
        //TODO 生成开门秘钥
        LingLingSDK.createSdkKey(devices);
        //TODO 更新开门秘钥到我们自己的数据库

        //TODO 生成业主二维码
        LingLingSDK.createQrcodeKey(devices,systemUser);
        userService.insertSystemUser(systemUser);
        //TODO 关联角色
        return Result.success("用户注册成功",systemUser);
    }

    @ResponseBody
    @RequestMapping("login")
    @ApiOperation(value = "用户登陆", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "用户登陆")
    public Result login(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone,
                        @ApiParam(required = true, name = "password", value = "验证码") @RequestParam String password) {
        //todo 校验密码
        String token = CryptographyUtil.md5(phone + password,"quanfangwei");
        EHCacheUtil.getInstance().put(EHCacheUtil.LOGIN_CACHE,token,phone);
        return Result.success("用户登陆成功",token);
    }

    @ResponseBody
    @RequestMapping("editPassword")
    @ApiOperation(value = "找回密码", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "找回密码")
    public Result editPassword(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone,
                           @ApiParam(required = true, name = "code", value = "验证码") @RequestParam String code,
                           @ApiParam(required = true, name = "password", value = "用户输入密码") @RequestParam String password,
                           @ApiParam(required = true, name = "passwordRepeat", value = "用户输入重复的密码") @RequestParam String passwordRepeat) {
        return Result.success("密码已重新设置");
    }


}
