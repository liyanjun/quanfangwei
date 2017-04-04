package org.li;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpPost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.li.common.util.ConnectUtil;
import org.li.common.util.face.FaceUtil;
import org.li.common.util.face.result.CompareResult;
import org.li.common.util.face.result.CreditCardResult;
import org.li.common.util.lingling.result.LingLingSdkKeyResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/28.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class TestMain {
    public static void main(String arg[]){
//        CreditCardResult creditCardResult = FaceUtil.readCreditCard("http://data.212200.com/forum/201603/11/095050w26r5kk56kf02k2s.jpeg");
////        CreditCardResult creditCardResult = FaceUtil.readCreditCard("http://bbs.gxsky.com/data/attachment/forum/201703/31/115435ammbisb971vpi369.jpg");
//        System.out.println(creditCardResult);
        CompareResult compareResult = FaceUtil.compareFace("http://data.212200.com/forum/201603/11/095050w26r5kk56kf02k2s.jpeg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491196327850&di=14e12e8eb17fc02ba39f96f2bf37d7dc&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D790499712%2C434819750%26fm%3D214%26gp%3D0.jpg");
        System.out.println(compareResult.getConfidence());
    }
//    @Test
    public void testMain() throws InterruptedException {

    }
}
