/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:SendMessage.java
 *    Date:2019/12/26 下午4:25
 *    Author:高源
 */

package action;

import com.opensymphony.xwork2.ActionContext;
import po.User;
import tool.SendSms;

import java.util.Map;
import java.util.Random;

public class SendMessage {
    private String verificationCode;
    private String phoneNumber;

    public String sendMes(){
        ActionContext ctx=ActionContext.getContext();
        Map request = (Map)ctx.get("request");
        Map<String,Object> session=ctx.getSession();
        SendSms sendSms=new SendSms();
        Random random=new Random();
        int randomCode=random.nextInt(9000)+1000;
        verificationCode=randomCode+"";
        if(sendSms.sendMsg(phoneNumber,"SMS_181197054",
                "{\"code\":\""+verificationCode+"\"}")){
            session.put("verificationCode",verificationCode);
            return "success";
        }
        else {
            request.put("tip","验证码发送失败");
            return "success";
        }

    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
