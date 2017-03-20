package org.li.common.util.lingling.result;

import org.apache.http.client.methods.HttpPost;
import org.li.common.util.ConnectUtil;
import org.li.module.user.bean.SvDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * 令令返回结果实体
 * Created by 衍君 on 2017/3/20.
 */
public abstract class LingLingResult {
    private String statusCode;
    private String methodName;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
