package org.li.common.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by 衍君 on 2017/3/18.
 */
public class CryptographyUtil {
    /**
     * Md5加密      Shiro中自带MD5没有解密
     * @param str   要加密的值
     * @param salt<span style="white-space:pre">  </span>可以看做是拌料
     * @return
     */
    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }
}
