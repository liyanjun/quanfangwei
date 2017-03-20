package org.li.module.system.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.li.common.util.CryptographyUtil;
import org.li.common.util.EHCacheUtil;
import org.li.common.vo.Result;
import org.li.module.lingling.service.SvOwnerService;
import org.li.module.system.service.SystemUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return Result.success("获取验证码成功");
    }

    @ResponseBody
    @RequestMapping("register")
    @ApiOperation(value = "用户注册", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "用户注册")
    public Result register(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone,
                           @ApiParam(required = true, name = "code", value = "验证码") @RequestParam String code,
                           @ApiParam(required = true, name = "password", value = "用户输入密码") @RequestParam String password,
                           @ApiParam(required = true, name = "passwordRepeat", value = "用户输入重复的密码") @RequestParam String passwordRepeat) {
        logger.debug(EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE,phone)+"");
        return Result.success("用户注册成功");
    }

    @ResponseBody
    @RequestMapping("login")
    @ApiOperation(value = "用户登陆", httpMethod = "POST", response = org.li.common.vo.Result.class, notes = "用户登陆")
    public Result login(@ApiParam(required = true, name = "phone", value = "用户输入的手机号") @RequestParam String phone,
                        @ApiParam(required = true, name = "password", value = "验证码") @RequestParam String password) {
        userService.find(1);
        svOwnerService.find(1);
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
