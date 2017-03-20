package org.li.common.util.lingling;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpPost;
import org.li.common.util.ConnectUtil;
import org.li.common.util.lingling.result.LingLingResult;
import org.li.module.system.bean.SystemUser;
import org.li.module.user.bean.SvDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by 衍君 on 2017/3/20.
 */
public class LingLingSDK {
    static Logger logger = LoggerFactory.getLogger(LingLingSDK.class);
    public static List<SvDevice> createSdkKey(List<SvDevice> devices){
        HttpPost httpPost = ConnectUtil.createPost("",null);
        httpPost.setHeader("token","");
        httpPost.setHeader("signature","");
        try {
            String response = ConnectUtil.submitPost(httpPost);
            LingLingResult lingLingResult = new Gson().fromJson(response,LingLingResult.class);

        } catch (IOException e) {
            logger.error("获取Sdkkey错误",e);
            e.printStackTrace();
        }
        return devices;
    }

    public static void createQrcodeKey(List<SvDevice> devices, SystemUser systemUser) {

    }
}
