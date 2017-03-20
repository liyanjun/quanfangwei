package org.li.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
* @ClassName: ConnectUtil 
* @Description: 连接第三方的相关工具 
* @date 2016年3月14日 下午3:11:33
*
 */
public class ConnectUtil {

   
    /**
     * post方法
     * @param url
     * @param postParams
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String submitPost(String url, Map<String, String> postParams)
        throws ClientProtocolException, IOException {
        HttpClient httpClient = createClient();
        HttpPost httpPost = createPost(url, postParams);
        HttpResponse response = httpClient.execute(httpPost);
        String reponseContent = getReponseContent(response, "utf-8");
        return reponseContent;
    }

    /**
     * post方法
     * @param httpPost
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String submitPost(HttpPost httpPost)
            throws ClientProtocolException, IOException {
        HttpClient httpClient = createClient();
        HttpResponse response = httpClient.execute(httpPost);
        String reponseContent = getReponseContent(response, "utf-8");
        return reponseContent;
    }

    /**
     * get 方法
     * @param url
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String submitGet(String url) throws ClientProtocolException, IOException {
        HttpClient httpClient = createClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = httpClient.execute(httpGet);
        String reponseContent = getReponseContent(response, "utf-8");//此处使用了平台默认字符集 huaiyu.du
        return reponseContent;
    }

    /**
     * 创建并包装client
     * 
     * @return
     */
    public static HttpClient createClient() {
        return new ClientWarper(new DefaultHttpClient());
    }

    /**
     * 创建post
     * @param url
     * @param postParams
     * @return
     */
    public static HttpPost createPost(String url, Map<String, String> postParams) {
        HttpPost httpPost = new HttpPost(url);
        if (postParams != null) {
            Iterator<String> keys = postParams.keySet().iterator();
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            while (keys.hasNext()) {
                String key = keys.next();
                if (postParams.get(key) != null && !postParams.get(key).equals("")) {
                    nvps.add(new BasicNameValuePair(key, postParams.get(key)));
                }
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            } catch (UnsupportedEncodingException e) {
//                log.error(e.getMessage(), e);
                return null;
            }
        }
        return httpPost;
    }

    /**
     * 提取响应信息
     * 
     * @param response
     * @param charSet
     * @return
     */
    public static String getReponseContent(HttpResponse response, String charSet) {
        HttpEntity entity = response.getEntity();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(entity.getContent(),
                charSet));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IllegalStateException e) {
//            log.error(e.getMessage(), e);
        } catch (IOException e) {
//            log.error(e.getMessage(), e);
        }
        return null;
    }

}
