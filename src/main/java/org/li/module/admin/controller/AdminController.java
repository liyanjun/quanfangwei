package org.li.module.admin.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.li.common.vo.Result;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员接口
 * Created by 衍君 on 2017/3/18.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @ResponseBody
    @RequestMapping("findPerson")
    @ApiOperation(value = "查询管理员辖内人员", httpMethod = "POST", response = Result.class, notes = "查询管理员辖内人员")
    public Result findPerson(@RequestHeader String token) {
        return Result.success("查询管理员辖内人员成功");
    }

    @ResponseBody
    @RequestMapping("findBuilding")
    @ApiOperation(value = "查询管理员所管理的楼栋住房", httpMethod = "POST", response = Result.class, notes = "查询管理员所管理的楼栋住房")
    public Result findBuilding(@RequestHeader String token) {
        return Result.success("查询管理员所管理的楼栋住房成功");
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
                            @RequestHeader String token) {
        return Result.success("新增用户成功");
    }

    @ResponseBody
    @RequestMapping("deletePerson")
    @ApiOperation(value = "删除用户", httpMethod = "POST", response = Result.class, notes = "删除用户")
    public Result deletePerson(@ApiParam(required = true, name = "phone", value = "用户手机号") @RequestParam String phone,
                               @RequestHeader String token) {
        return Result.success("删除用户成功");
    }

    @ResponseBody
    @RequestMapping("editPerson")
    @ApiOperation(value = "编辑用户", httpMethod = "POST", response = Result.class, notes = "编辑用户")
    public Result editPerson(@ApiParam(required = true, name = "phone", value = "用户手机号") @RequestParam String phone,
                             @ApiParam(required = true, name = "addressId", value = "楼栋住房ID") @RequestParam String addressId,
                             @ApiParam(required = true, name = "beginTime", value = "有效期开始时间") @RequestParam String beginTime,
                             @ApiParam(required = true, name = "endTime", value = "有效期结束时间") @RequestParam String endTime,
                             @RequestHeader String token) {
        return Result.success("编辑用户成功");
    }
}
