package org.li.common.util.lingling.result;

import com.google.gson.JsonObject;

/**
 * 生成二维码令令返回结果实体
 * Created by 衍君 on 2017/3/20.
 */
public class LingLingQrcodeResult extends LingLingResult {
    private JsonObject responseResult;

    public JsonObject getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(JsonObject responseResult) {
        this.responseResult = responseResult;
    }
}
