package org.li.module.admin.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.li.common.util.DateUtil;
import org.li.common.util.EHCacheUtil;
import org.li.common.vo.Result;
import org.li.module.lingling.bean.*;
import org.li.module.lingling.service.SvOwnerService;
import org.li.module.system.bean.SystemUser;
import org.li.module.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * 管理员接口
 * Created by 衍君 on 2017/3/18.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    SvOwnerService svOwnerService;

    @Autowired
    SystemUserService systemUserService;

    @ResponseBody
    @RequestMapping("findPerson")
    @ApiOperation(value = "查询管理员辖内人员", httpMethod = "POST", response = Result.class, notes = "查询管理员辖内人员")
    public Result findPerson(@RequestParam String token,
                             @ApiParam(required = true,name = "first",value = "当前浏览到的记录-1") @RequestParam Integer first,
                             @ApiParam(required = true,name = "count",value = "本次要加载的记录") @RequestParam Integer count) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        List<SvOwner> svOwners = svOwnerService.findLingLingUserInfoList(systemUser.getOwnerId(),first,count);
        return Result.success("查询管理员辖内人员成功",svOwners);
    }

    @ResponseBody
    @RequestMapping("findBuilding")
    @ApiOperation(value = "查询管理员所管理的楼栋住房", httpMethod = "POST", response = Result.class, notes = "查询管理员所管理的楼栋住房")
    public Result findBuilding(@RequestParam String token,
                               @ApiParam(required = true,name = "first",value = "当前浏览到的记录-1") @RequestParam Integer first,
                               @ApiParam(required = true,name = "count",value = "本次要加载的记录") @RequestParam Integer count) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        List<SvResidential> svResidentials = svOwnerService.findManagerBuilding(systemUser.getOwnerId(),first,count);
        return Result.success("查询管理员所管理的楼栋住房成功",svResidentials);
    }

    @ResponseBody
    @RequestMapping("addPerson")
    @ApiOperation(value = "新增用户", httpMethod = "POST", response = Result.class, notes = "新增用户")
    public Result addPerson(@ApiParam(required = true, name = "username", value = "用户姓名") @RequestParam String username,
                            @ApiParam(required = true, name = "sex", value = "性别(0:男，1：女)") @RequestParam Integer sex,
                            @ApiParam(required = true, name = "nation", value = "民族") @RequestParam String nation,
                            @ApiParam(required = true, name = "birthday", value = "生日") @RequestParam String birthday,
                            @ApiParam(required = true, name = "creditAddress", value = "身份证地址") @RequestParam String creditAddress,
                            @ApiParam(required = true, name = "creditNo", value = "身份证号") @RequestParam String creditNo,
                            @ApiParam(required = true, name = "creditImgUrl", value = "身份证照地址") @RequestParam String creditImgUrl,
                            @ApiParam(required = true, name = "headImgUrl", value = "大头自拍照地址") @RequestParam String headImgUrl,
                            @ApiParam(required = true, name = "phone", value = "用户手机号") @RequestParam String phone,
                            @ApiParam(required = true, name = "addressId", value = "楼栋住房ID") @RequestParam String addressId,
                            @ApiParam(required = true, name = "beginTime", value = "有效期开始时间") @RequestParam String beginTime,
                            @ApiParam(required = true, name = "endTime", value = "有效期结束时间") @RequestParam String endTime,
                            @RequestParam String token) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        return Result.success("新增用户成功");
    }

    @ResponseBody
    @RequestMapping("deletePerson")
    @ApiOperation(value = "删除用户", httpMethod = "POST", response = Result.class, notes = "删除用户")
    public Result deletePerson(@ApiParam(required = true, name = "phone", value = "用户手机号") @RequestParam String phone,
                               @RequestParam String token) {
        SystemUser admin = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        SystemUser systemUser = systemUserService.findByPhone(phone);
        if(systemUser == null){
            return Result.fail("该用户不存在");
        }
        systemUserService.delete(systemUser.getId());
        // TODO 在他们的数据库删除
        return Result.success("删除用户成功");
    }

    @ResponseBody
    @RequestMapping("editPerson")
    @ApiOperation(value = "编辑用户", httpMethod = "POST", response = Result.class, notes = "编辑用户")
    public Result editPerson(@ApiParam(required = true, name = "phone", value = "用户手机号") @RequestParam String phone,
                             @ApiParam(required = true, name = "addressId", value = "楼栋住房ID") @RequestParam Integer addressId,
                             @ApiParam(required = true, name = "addressName", value = "楼栋住房名称") @RequestParam String addressName,
                             @ApiParam(required = true, name = "beginTime", value = "有效期开始时间") @RequestParam String beginTime,
                             @ApiParam(required = true, name = "endTime", value = "有效期结束时间") @RequestParam String endTime,
                             @RequestParam String token) {
        SystemUser admin = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        SystemUser systemUser = systemUserService.findByPhone(phone);
        if(systemUser == null){
            return Result.fail("该用户不存在");
        }

        systemUser.setAddressId(addressId);
        systemUser.setAddress(addressName);
       /* try {
            systemUser.setBeginDate(DateUtil.strToTimestamp(beginTime));
            systemUser.setEndDate(DateUtil.strToTimestamp(endTime));
        } catch (ParseException e) {
            return Result.fail("日期格式不正确");
        }*/
        systemUserService.updateSystemUser(systemUser);
        // TODO 更新他们的数据库
        return Result.success("编辑用户成功");
    }
}
