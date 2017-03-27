package org.li.module.user.controller;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.li.common.util.DateUtil;
import org.li.common.util.EHCacheUtil;
import org.li.common.util.lingling.LingLingSDK;
import org.li.common.util.lingling.result.LingLingOpenResult;
import org.li.common.util.lingling.result.LingLingQrcodeResult;
import org.li.common.vo.Result;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.lingling.bean.SvVisitorQrcode;
import org.li.module.lingling.service.SvOwnerService;
import org.li.module.system.bean.SystemUser;
import org.li.module.user.bean.SvQrcode;
import org.li.module.user.service.SvQrcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collections;
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

    @Autowired
    SvQrcodeService svQrcodeService;

    @ResponseBody
    @RequestMapping("createQRCode")
    @ApiOperation(value = "二维码生成", httpMethod = "POST", response = Result.class, notes = "生成门禁二维码")
    public Result createQRCode(@RequestParam String token) {
//        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
//        if(systemUser.getRoleId() == 3){
////            svOwnerService.fin
//            List<String> sdkKeys = LingLingSDK.createAdminSdkKey();
//        }
//        // TODO 查询用户角色，判断需要生成用户二维码还是管理员二维码
//        List<SvLingLingDevice> devices = svOwnerService.findUserDevices(systemUser.getOwnerId(), null, null);
//        List<String> sdkKeys = LingLingSDK.createSdkKey(devices);
//        String qrcode = LingLingSDK.createQrcodeKey(sdkKeys, systemUser);
        return Result.success("二维码生成成功", "F2EB940855150DD1DEE75408770F7C9C001196F3C2025E40B9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720");
    }

    @ResponseBody
    @RequestMapping("createVisitorQRCode")
    @ApiOperation(value = "访客二维码生成", httpMethod = "POST", response = Result.class, notes = "业主或者管理员用户生成访客门禁二维码")
    public Result createVisitorQRCode(@ApiParam(required = true, name = "name", value = "访客名") @RequestParam String name,
                                      @ApiParam(required = true, name = "visitorPhone", value = "访客的手机号") @RequestParam String visitorPhone,
                                      @ApiParam(required = true, name = "visitorDate", value = "访问日期（年月日，如2016-03-16）") @RequestParam String visitorDate,
                                      @ApiParam(required = true, name = "token", value = "token") @RequestParam String token) {
//        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
//        SvQrcode svQrcode = new SvQrcode();
//        if(systemUser.getRoleId() == 3){
////            svOwnerService.fin
//            List<String> sdkKeys = LingLingSDK.createAdminSdkKey();
//
//        }
//
//        // TODO 查询用户角色，判断需要生成用户二维码还是管理员二维码
//        svQrcode.setType(2);
//        svQrcode.setName(name);
//        svQrcode.setVisitPhone(visitorPhone);
//        try {
//            svQrcode.setStartTime(DateUtil.strToTimestamp(visitorDate + " 00:00:00"));
//        } catch (ParseException e) {
//            Result.fail("时间格式有误");
//        }
//        svQrcode.setEndTime(4095);
//        svQrcode.setUserId(systemUser.getId());
//
//        List<SvLingLingDevice> devices = svOwnerService.findUserDevices(systemUser.getOwnerId(), null, null);
//        List<String> sdkKeys = LingLingSDK.createSdkKey(devices);
//        JsonObject qrCode = LingLingSDK.createVisitorQRCode(sdkKeys,systemUser);
//        svQrcode.setQrcodeKey(qrCode.get("qrcodeKey").getAsString());
//        svQrcode.setCodeId(qrCode.get("codeId").getAsInt());
//        svQrcodeService.insertSvQrcode(svQrcode);
        return Result.success("访客二维码生成成功","F2EB940855150DD1DEE75408770F7C9C001196F3C2025E40B9492034C1F5CEAD8ED77B0D1D7D3E0B9CA6A32C9CA6A32CCC19B184ABDD3720");
//        return Result.success("访客二维码生成成功",svQrcode.getQrcodeKey());
    }

    @ResponseBody
    @RequestMapping("findDev")
    @ApiOperation(value = "查询用户可用门禁设备", httpMethod = "POST", response = Result.class, notes = "查询用户可用门禁设备")
    public Result findDev(@RequestParam String token,
                          @ApiParam(required = true, name = "first", value = "当前浏览到的记录-1") @RequestParam Integer first,
                          @ApiParam(required = true, name = "count", value = "本次要加载的记录") @RequestParam Integer count) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        List<SvLingLingDevice> svLingLingDeviceList = svOwnerService.findUserDevices(systemUser.getOwnerId(), first, count);
        return Result.success("查询用户可用门禁设备成功", svLingLingDeviceList);
    }

    @ResponseBody
    @RequestMapping("open")
    @ApiOperation(value = "开门", httpMethod = "POST", response = Result.class, notes = "业主或者管理员选择设备开门")
    public Result open(@ApiParam(required = true, name = "devId", value = "设备Id") @RequestParam Integer devId,
                       @RequestParam String token) {
        LingLingOpenResult result = null;
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        // TODO 处理管理员逻辑
        List<SvLingLingDevice> svLingLingDeviceList = svOwnerService.findUserDevices(systemUser.getOwnerId(), null, null);
        for (SvLingLingDevice svLingLingDevice : svLingLingDeviceList) {
            //检查用户是否拥有这个设备
            if (svLingLingDevice.getDeviceId().intValue() != devId.intValue()) {
                continue;
            }
            List<String> sdkKeys = LingLingSDK.createSdkKey(Collections.singletonList(svLingLingDevice));
            if (sdkKeys.size() > 0) {
                result = LingLingSDK.open(sdkKeys.iterator().next());
            }
        }
        if(result == null){
            return Result.fail("开门失败");
        }
        if(!"1".equals(result.getStatusCode())){
            return Result.fail(result.getResponseResult());
        }
        return Result.success(result.getResponseResult());
    }

    @ResponseBody
    @RequestMapping("findVisitRecord")
    @ApiOperation(value = "查询访客记录", httpMethod = "POST", response = Result.class, notes = "查询访客记录")
    public Result findVisitRecord(@RequestParam String token,
                                  @ApiParam(required = true, name = "first", value = "当前浏览到的记录-1") @RequestParam Integer first,
                                  @ApiParam(required = true, name = "count", value = "本次要加载的记录") @RequestParam Integer count) {
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        List<SvQrcode> svQrcodes = svQrcodeService.findByUserId(systemUser.getId());
        for (SvQrcode svQrcode : svQrcodes){
            List<SvVisitorQrcode> svVisitorQrcodes = svOwnerService.findVisitRecord(systemUser.getOwnerId(),svQrcode.getCodeId(), first, count);
            svQrcode.setSvVisitorQrcodes(svVisitorQrcodes);
        }
        return Result.success("查询访客记录成功", svQrcodes);
    }

}
