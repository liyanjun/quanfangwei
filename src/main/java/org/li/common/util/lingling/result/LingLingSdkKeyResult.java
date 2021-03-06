package org.li.common.util.lingling.result;

import com.google.gson.JsonObject;

/**
 * SDK秘钥令令返回结果实体
 * Created by 衍君 on 2017/3/20.
 */
public class LingLingSdkKeyResult extends LingLingResult {
    private JsonObject responseResult;

    public JsonObject getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(JsonObject responseResult) {
        this.responseResult = responseResult;
    }
}
