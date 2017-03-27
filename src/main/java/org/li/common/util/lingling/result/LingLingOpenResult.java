package org.li.common.util.lingling.result;

import com.google.gson.JsonObject;

/**
 * 生成二维码令令返回结果实体
 * Created by 衍君 on 2017/3/20.
 */
public class LingLingOpenResult extends LingLingResult {
    private String responseResult;

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }
}
