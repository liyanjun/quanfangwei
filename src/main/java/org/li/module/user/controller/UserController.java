package org.li.module.user.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.li.common.util.EHCacheUtil;
import org.li.common.util.lingling.LingLingSDK;
import org.li.common.vo.Result;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.lingling.bean.SvVisitorQrcode;
import org.li.module.lingling.service.SvOwnerService;
import org.li.module.system.bean.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户接口
 * Created by liyanjun on 2017/3/7.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    SvOwnerService svOwnerService;

    @ResponseBody
    @RequestMapping("createQRCode")
    @ApiOperation(value = "二维码生成", httpMethod = "POST", response = Result.class, notes = "生成门禁二维码")
    public Result createQRCode(@RequestHeader String token) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);

        // TODO 查询用户角色，判断需要生成用户二维码还是管理员二维码
        List<SvLingLingDevice> devices = svOwnerService.findUserDevices(systemUser.getOwnerId(), null, null);
        //TODO 生成开门秘钥
        LingLingSDK.createSdkKey(devices);
        //TODO 生成业主二维码
        LingLingSDK.createQrcodeKey(devices, systemUser);
        return Result.success("二维码生成成功");
    }

    @ResponseBody
    @RequestMapping("createVisitorQRCode")
    @ApiOperation(value = "访客二维码生成", httpMethod = "POST", response = Result.class, notes = "业主或者管理员用户生成访客门禁二维码")
    public Result createVisitorQRCode(@ApiParam(required = true, name = "name", value = "访客名") @RequestParam String name,
                                      @ApiParam(required = true, name = "visitorPhone", value = "访客的手机号") @RequestParam String visitorPhone,
                                      @ApiParam(required = true, name = "visitorDate", value = "访问日期（年月日，如2016-03-16）") @RequestParam String visitorDate,
                                      @RequestHeader String token) {
        return Result.success("访客二维码生成成功");
    }

    @ResponseBody
    @RequestMapping("findDev")
    @ApiOperation(value = "查询用户可用门禁设备", httpMethod = "POST", response = Result.class, notes = "查询用户可用门禁设备")
    public Result findDev(@RequestHeader String token,@ApiParam(required = true,name = "first",value = "当前浏览到的记录-1") Integer first,@ApiParam(required = true,name = "count",value = "本次要加载的记录") Integer count) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        if(systemUser == null){
            return Result.fail("登录超时");
        }
        List<SvLingLingDevice> svLingLingDeviceList = svOwnerService.findUserDevices(systemUser.getOwnerId(),first,count);
        return Result.success("查询用户可用门禁设备成功",svLingLingDeviceList);
    }

    @ResponseBody
    @RequestMapping("open")
    @ApiOperation(value = "开门", httpMethod = "POST", response = Result.class, notes = "业主或者管理员选择设备开门")
    public Result open(@ApiParam(required = true, name = "devId", value = "设备Id") @RequestParam String devId,
                       @RequestHeader String token) {
        return Result.success("开门成功");
    }

    @ResponseBody
    @RequestMapping("findVisitRecord")
    @ApiOperation(value = "查询访客记录", httpMethod = "POST", response = Result.class, notes = "查询访客记录")
    public Result findVisitRecord(@RequestHeader String token,@ApiParam(required = true,name = "first",value = "当前浏览到的记录-1") Integer first,@ApiParam(required = true,name = "count",value = "本次要加载的记录") Integer count) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        if(systemUser == null){
            return Result.fail("登录超时");
        }
        List<SvVisitorQrcode> svVisitorQrcodes = svOwnerService.findVisitRecord(systemUser.getOwnerId(),first,count);
        return Result.success("查询访客记录成功",svVisitorQrcodes);
    }

}
