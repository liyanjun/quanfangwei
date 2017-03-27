package org.li.common.util.lingling;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpPost;
import org.li.common.util.ConnectUtil;
import org.li.common.util.DateUtil;
import org.li.common.util.ParameterUtil;
import org.li.common.util.lingling.request.Message;
import org.li.common.util.lingling.result.LingLingOpenResult;
import org.li.common.util.lingling.result.LingLingQrcodeResult;
import org.li.common.util.lingling.result.LingLingSdkKeyResult;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.system.bean.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 衍君 on 2017/3/20.
 */
public class LingLingSDK {
    static Logger logger = LoggerFactory.getLogger(LingLingSDK.class);
    static String url = "http://115.29.49.78:8889/cgi-bin";

    public static List<String> createSdkKey(List<SvLingLingDevice> devices) {
        // TODO 记录通讯log
        List<String> sdkKeys = new ArrayList<>();
        List<Integer> deviceIds = ParameterUtil.getDeviceId(devices);
        Map<String, String> map = new HashMap<>();
        Message m = new Message();
        m.getRequestParam().put("deviceIds", deviceIds);
        m.getRequestParam().put("keyEffecDay", 180);
        map.put("MESSAGE", new Gson().toJson(m));
        HttpPost httpPost = ConnectUtil.createPost(url + "/key/makeSdkKey/21F2548CC77394880637C358419E6596", map);
        try {
            String response = ConnectUtil.submitPost(httpPost);
            LingLingSdkKeyResult lingLingResult = new Gson().fromJson(response, LingLingSdkKeyResult.class);
            for (SvLingLingDevice svLingLingDevice : devices) {
                JsonElement sdkKey = lingLingResult.getResponseResult().get(svLingLingDevice.getV3DeviceId() + "");
                if (sdkKey != null) {
                    sdkKeys.add(sdkKey.getAsString());
                }
            }
        } catch (IOException e) {
            logger.error("获取Sdkkey错误", e);
            throw new RuntimeException(e);
        }
        return sdkKeys;
    }

    public static String createQrcodeKey(List<String> sdkKeys, SystemUser systemUser) {
        LingLingQrcodeResult result = null;
        List<String> sdkKey = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        Message m = new Message();
        m.getRequestParam().put("sdkKeys", sdkKeys);
        m.getRequestParam().put("endTime", 4095);
        m.getRequestParam().put("lingLingId", systemUser.getLinglingId());
        m.getRequestParam().put("strKey", "ABDD3720");
        map.put("MESSAGE", new Gson().toJson(m));
        HttpPost httpPost = ConnectUtil.createPost(url + "/qrcode/addOwnerQrCode/21F2548CC77394880637C358419E6596", map);
        try {
            String response = ConnectUtil.submitPost(httpPost);
            result = new Gson().fromJson(response, LingLingQrcodeResult.class);
        } catch (IOException e) {
            logger.error("获取用户二维码错误", e);
            throw new RuntimeException(e);
        }
        return result.getResponseResult().get("qrcodeKey").getAsString();
    }

    public static LingLingOpenResult open(String sdkKey) {
        LingLingOpenResult result = null;
        Map<String, String> map = new HashMap<>();
        Message m = new Message();
        m.getRequestParam().put("sdkKey", sdkKey);
        map.put("MESSAGE", new Gson().toJson(m));
        HttpPost httpPost = ConnectUtil.createPost(url + "/key/remoteOpenDoor/21F2548CC77394880637C358419E6596", map);
        try {
            String response = ConnectUtil.submitPost(httpPost);
            result = new Gson().fromJson(response, LingLingOpenResult.class);
        } catch (IOException e) {
            logger.error("远程开门错误", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<String> createAdminSdkKey() {
        return null;
    }

    public static JsonObject createVisitorQRCode(List<String> sdkKeys, SystemUser systemUser) {
        LingLingQrcodeResult result = null;
        List<String> sdkKey = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        Message m = new Message();
        m.getRequestParam().put("sdkKeys", sdkKeys);
        m.getRequestParam().put("startTime", DateUtil.getCurrentTimestamp().toString());
        m.getRequestParam().put("endTime", 4095);
        m.getRequestParam().put("lingLingId", systemUser.getLinglingId());
        m.getRequestParam().put("effecNumber", "255");
        m.getRequestParam().put("strKey", "ABDD3720");
        map.put("MESSAGE", new Gson().toJson(m));
        HttpPost httpPost = ConnectUtil.createPost(url + "/qrcode/addVisitorQrCode/21F2548CC77394880637C358419E6596", map);
        try {
            String response = ConnectUtil.submitPost(httpPost);
            result = new Gson().fromJson(response, LingLingQrcodeResult.class);
        } catch (IOException e) {
            logger.error("获取访客二维码错误", e);
            throw new RuntimeException(e);
        }
        return result.getResponseResult();
    }
}
