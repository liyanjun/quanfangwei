package org.li.common.util.face;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpPost;
import org.li.common.util.ConnectUtil;
import org.li.common.util.face.result.CompareResult;
import org.li.common.util.face.result.CreditCardResult;
import org.li.common.util.lingling.LingLingSDK;
import org.li.common.util.lingling.request.Message;
import org.li.common.util.lingling.result.LingLingQrcodeResult;
import org.li.module.system.bean.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 衍君 on 2017/4/3.
 */
public class FaceUtil {
    static Logger logger = LoggerFactory.getLogger(LingLingSDK.class);

    private static String APIKey = "wsQuMopNQGYZRckQt8aPH8uFUKDsN4Vm";
    private static String APISecret = "ZG7CiZuG2PQOHW3nm1LBcJQzCJ_h2sgA";
    private static String creditCardUrl = "https://api-cn.faceplusplus.com/cardpp/v1/ocridcard";
    private static String faceCompareUrl = "https://api-cn.faceplusplus.com/facepp/v3/compare";

    public static CreditCardResult readCreditCard(String imageUrl) {
        CreditCardResult creditCardResult = null;
        Map<String, String> map = new HashMap<>();
        map.put("api_key", APIKey);
        map.put("api_secret", APISecret);
        map.put("image_url", imageUrl);
        map.put("legality", String.valueOf(1));
        HttpPost httpPost = ConnectUtil.createPost(creditCardUrl, map);
        String response = "";
        try {
            response = ConnectUtil.submitPost(httpPost);
            creditCardResult = new Gson().fromJson(response,CreditCardResult.class);
        } catch (IOException e) {
            logger.error("获取用户身份证信息", e);
            throw new RuntimeException(e);
        }
        return creditCardResult;
    }

    public static CompareResult compareFace(String creditCardUrl,String faceUrl) {
        CompareResult compareResult = null;
        Map<String, String> map = new HashMap<>();
        map.put("api_key", APIKey);
        map.put("api_secret", APISecret);
        map.put("image_url1", creditCardUrl);
        map.put("image_url2", faceUrl);
        HttpPost httpPost = ConnectUtil.createPost(faceCompareUrl, map);
        String response = "";
        try {
            response = ConnectUtil.submitPost(httpPost);
            compareResult = new Gson().fromJson(response,CompareResult.class);
        } catch (IOException e) {
            logger.error("获取用户身份证信息", e);
            throw new RuntimeException(e);
        }
        return compareResult;
    }
}
