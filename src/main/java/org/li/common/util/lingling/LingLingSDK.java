package org.li.common.util.lingling;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpPost;
import org.li.common.util.ConnectUtil;
import org.li.common.util.DateUtil;
import org.li.common.util.ParameterUtil;
import org.li.common.util.lingling.request.Message;
import org.li.common.util.lingling.result.LingLingResult;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.system.bean.SystemUser;
import org.li.module.user.bean.SvDevice;
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
    public static List<SvDevice> createSdkKey(List<SvLingLingDevice> devices){
        List<SvDevice> svDevices = new ArrayList<>();
        List<Integer> deviceIds = ParameterUtil.getDeviceId(devices);
        Map<String,String> map = new HashMap<>();
        Message m = new Message();
        m.getRequestParam().put("deviceIds",deviceIds);
        m.getRequestParam().put("keyEffecDay",180);
//        map.put("MESSAGE","{requestParam:{deviceIds:[17],keyEffecDay:180}," +
//                "header:{token:\"1490061178054\",signature:\"191c20fa-ee58-407c-b8e3-bbba3678f297\"}}");
        map.put("MESSAGE",new Gson().toJson(m));
        HttpPost httpPost = ConnectUtil.createPost("http://115.29.49.78:8889/cgi-bin/key/makeSDKKey/21F2548CC77394880637C358419E6596",map);
        try {
            String response = ConnectUtil.submitPost(httpPost);
            LingLingResult lingLingResult = new Gson().fromJson(response,LingLingResult.class);

        } catch (IOException e) {
            logger.error("获取Sdkkey错误",e);
            throw new RuntimeException(e);
        }
        for (SvLingLingDevice svLingLingDevice : devices) {
            if(svLingLingDevice!=null) {
                SvDevice svDevice = new SvDevice();
                // TODO 生成我们自己的设备记录
                svDevices.add(svDevice);
            }
        }
        return svDevices;
    }

    public static void createQrcodeKey(List<SvLingLingDevice> devices, SystemUser systemUser) {
        systemUser.setQrcodeKey("asdf");
        systemUser.setQrcodeCreateTime(DateUtil.getCurrentTimestamp());
    }
}
