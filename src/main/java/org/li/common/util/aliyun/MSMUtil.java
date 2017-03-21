package org.li.common.util.aliyun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 衍君 on 2017/3/21.
 */
public class MSMUtil {
    private static Logger logger = LoggerFactory.getLogger(MSMUtil.class);
    public static void sendCaptchaMSM(String captcha){
        try {
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "your accessKey", "your accessSecret");
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms",  "sms.aliyuncs.com");
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName("测试签名");//控制台创建的签名名称
            request.setTemplateCode("SMS_111111");//控制台创建的模板CODE
            request.setParamString("{\"name\":\"123\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
            //request.setParamString("{}");
            request.setRecNum("13000001111");//接收号码
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
        } catch (Exception e) {
            logger.error("发送短信错误",e);
            throw new RuntimeException(e);
        }
    }

}
