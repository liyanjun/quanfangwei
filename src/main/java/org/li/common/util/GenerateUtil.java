package org.li.common.util;

import java.util.Random;

/**
 * Created by 衍君 on 2017/3/20.
 */
public class GenerateUtil {
    /**
     * 生成6位手机验证码，等等
     * @author liyanjun
     * @return
     */
    public static synchronized String geneCaptcha() {
        Random random = new Random();
        int x = random.nextInt(899999);
        x = x+100000;
        return x+"";
    }
}
