package org.li.common.util.aliyun;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudTopic;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.common.ServiceException;
import com.aliyun.mns.model.BatchSmsAttributes;
import com.aliyun.mns.model.MessageAttributes;
import com.aliyun.mns.model.RawTopicMessage;
import com.aliyun.mns.model.TopicMessage;
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
    public static void sendCaptchaMSM(String phone,String captcha){
        try {
            /**
             * Step 1. get topic reference
             */
            CloudAccount account = new CloudAccount("LTAIG1IngzxcjvqW", "xNVGfudqlGyxUM5pbVzqbOc9a0u2ne", "http://1264988253715856.mns.cn-hangzhou.aliyuncs.com");
            MNSClient client = account.getMNSClient();
            CloudTopic topic = client.getTopicRef("sms.topic-cn-hangzhou");
            /**
             * Step 2. set SMS message body ( required )
             */
            RawTopicMessage msg = new RawTopicMessage();
            msg.setMessageBody("sms-message");
            /**
             * Step 3. generate SMS message attributes
             */
            MessageAttributes messageAttributes = new MessageAttributes();
            BatchSmsAttributes batchSmsAttributes = new BatchSmsAttributes();
            // 3.1 set SMS message sign name
            batchSmsAttributes.setFreeSignName("全方卫");
            // 3.2 set SMS message template code
            batchSmsAttributes.setTemplateCode("SMS_60135554");
            // 3.3 set SMS message receiver param (defined in SMS message template)
            BatchSmsAttributes.SmsReceiverParams smsReceiverParams = new BatchSmsAttributes.SmsReceiverParams();
            smsReceiverParams.setParam("code", "captcha");
            // 3.4 add phone number of receiver (200 receivers at most)
            batchSmsAttributes.addSmsReceiver(phone, smsReceiverParams);
            messageAttributes.setBatchSmsAttributes(batchSmsAttributes);
            try {
                /**
                 * Step 4. publish SMS message
                 */
                TopicMessage ret = topic.publishMessage(msg, messageAttributes);
                System.out.println("MessageId: " + ret.getMessageId());
                System.out.println("MessageMD5: " + ret.getMessageBodyMD5());
            } catch (ServiceException se) {
                System.out.println(se.getErrorCode() + se.getRequestId());
                System.out.println(se.getMessage());
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            client.close();
//            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIG1IngzxcjvqW", "xNVGfudqlGyxUM5pbVzqbOc9a0u2ne");
//            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms",  "sms.aliyuncs.com");
//            IAcsClient client = new DefaultAcsClient(profile);
//            SingleSendSmsRequest request = new SingleSendSmsRequest();
//            request.setSignName("全方卫");//控制台创建的签名名称
//            request.setTemplateCode("SMS_60135554");//控制台创建的模板CODE
//            request.setParamString("{\"code\":\""+captcha+"\"}");//短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
//            //request.setParamString("{}");
//            request.setRecNum(phone);//接收号码
//            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
        } catch (Exception e) {
            logger.error("发送短信错误",e);
            throw new RuntimeException(e);
        }
    }

}
