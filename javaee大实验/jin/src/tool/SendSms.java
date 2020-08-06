/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:SendSms.java
 *    Date:2019/12/26 下午3:45
 *    Author:高源
 */

package tool;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;

public class SendSms {

    private Log logger= LogFactory.getLog(SendSms.class);

    final String accessKeyId ="";//你的accessKeyId,

    final String accessKeySecret ="";//你的accessKeySecret

    public boolean sendMsg(String phone, String templateCode, String templateParam) {

        boolean bool =false;

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);

        IAcsClient client =new DefaultAcsClient(profile);

        CommonRequest request =new CommonRequest();

        request.setMethod(MethodType.POST);

        request.setDomain("dysmsapi.aliyuncs.com");

        request.setVersion("2017-05-25");// 版本信息  已经固定  不能进行更改

//必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”

        request.putQueryParameter("PhoneNumbers", phone);

        //  阿里云控制台签名

        String signName ="gdAirplan";

        request.putQueryParameter("SignName", signName);

        // 阿里云控制台模板编号

        request.putQueryParameter("TemplateCode", templateCode);

        request.setAction("SendSms");//系统规定参数

        // 模板内需要填充参数信息

        request.putQueryParameter("TemplateParam", templateParam);

        try {

            logger.debug("调用阿里云短信服务请求 phone={"+phone+"}，templateCode={"+templateCode+"},templateParam={"+templateParam+"}");

            CommonResponse response = client.getCommonResponse(request);

            // 下面是一个json格式转换工具，把String 转换为map 也可以转换为对象

            Map map = (Map) JSON.parse(response.getData());

            if ("OK".equals(map.get("Code"))) {

                bool =true;

            }

        }catch (ServerException e) {

            logger.error("阿里云短信服务异常:{}", e);

        }catch (ClientException e) {

            logger.error("连接阿里云短信异常:{}", e);

        }catch (Exception e) {

            logger.error("json转换异常:{}", e);

        }

        return bool;

    }
}
