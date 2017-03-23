package org.li.common.util.lingling.request;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * 令令SDK消息调用，请求接口格式
 * Created by liyanjun on 2017/3/22.
 */
public class Message {

    private Map<String, Object> requestParam;
    private Map<String, Object> header;

    public Message() {
        requestParam = new HashedMap();
        header = new HashedMap();
        header.put("token","1490061178054");
        header.put("signature","191c20fa-ee58-407c-b8e3-bbba3678f297");
    }

    public Map<String, Object> getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(Map<String, Object> requestParam) {
        this.requestParam = requestParam;
    }

    public Map<String, Object> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Object> header) {
        this.header = header;
    }
}
