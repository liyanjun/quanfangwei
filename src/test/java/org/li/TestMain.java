package org.li;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.li.common.util.ConnectUtil;
import org.li.common.util.lingling.LingLingSDK;
import org.li.common.util.lingling.result.LingLingResult;
import org.li.common.util.lingling.result.LingLingSdkKeyResult;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/28.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:spring/spring-mvc.xml"})
public class TestMain {
    public static void main(String arg[]){
        Map<String,String> map = new HashMap<>();
        map.put("MESSAGE","{requestParam:{deviceIds:[4191],keyEffecDay:180},header:{token:\"1490061178054\",signature:\"191c20fa-ee58-407c-b8e3-bbba3678f297\"}}");
        HttpPost httpPost = ConnectUtil.createPost("http://115.29.49.78:8889/cgi-bin/key/makeSdkKey/21F2548CC77394880637C358419E6596",map);
        try {
            String response = ConnectUtil.submitPost(httpPost);
            LingLingSdkKeyResult lingLingResult = new Gson().fromJson(response,LingLingSdkKeyResult.class);
            System.out.println(lingLingResult.getResponseResult().get("4191"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    @Test
    public void testMain() throws InterruptedException {

    }
}
