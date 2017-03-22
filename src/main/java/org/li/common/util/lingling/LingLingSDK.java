package org.li.common.util.lingling;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpPost;
import org.li.common.util.ConnectUtil;
import org.li.common.util.ParameterUtil;
import org.li.common.util.lingling.result.LingLingResult;
import org.li.module.lingling.bean.SvLingLingDevice;
import org.li.module.system.bean.SystemUser;
import org.li.module.user.bean.SvDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 衍君 on 2017/3/20.
 */
public class LingLingSDK {
    static Logger logger = LoggerFactory.getLogger(LingLingSDK.class);
    public static List<SvLingLingDevice> createSdkKey(List<SvLingLingDevice> devices){
        String deviceIds = ParameterUtil.getDeviceId(devices);
        Map<String,String> paramterMap = new HashMap();
        Map<String,String> map = new HashMap<>();
        map.put("deviceIds",deviceIds);
        map.put("keyEffecDay","180");
        paramterMap.put("requestParam",new Gson().toJson(map));
        map.clear();
        map.put("token","1489806448986");
        map.put("signature","69abeeba-fbc7-4b1a-903a-4a1a6beb6160");
        paramterMap.put("header",new Gson().toJson(map));
        map.clear();
        map.put("MESSAGE","{requestParam:{deviceIds:[17],keyEffecDay:180},header:{token:\"1489806448986\",signature:\"69abeeba-fbc7-4b1a-903a-4a1a6beb6160\"}}");
        HttpPost httpPost = ConnectUtil.createPost("http://120.24.172.108:8889/cgi-bin/key/makeSDKKey/2859441A22A912349035C58DC764159A",map);
        try {
            String response = ConnectUtil.submitPost(httpPost);
            LingLingResult lingLingResult = new Gson().fromJson(response,LingLingResult.class);

        } catch (IOException e) {
            logger.error("获取Sdkkey错误",e);
            throw new RuntimeException(e);
        }
        return devices;
    }

    public static void createQrcodeKey(List<SvLingLingDevice> devices, SystemUser systemUser) {

    }
}
