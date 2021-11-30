package com.example.login1.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.login1.service.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 昊洋
 * @date:2020-07-15 1:09
 * @description: SendSmsimpl
 * @version: 1.0
 */
@Service
public class SendSmsimpl implements SendSms {

    private final static String templateCode="SMS_196655221";
    private final static String accessKeyid="LTAI4FxvmopGrPzJN3naoFaz";
    private final static String secret="RWQ3oJxkasfx6RaK7vOgg5MCFFeUf1";
    @Override
    public boolean send(String phoneNum,String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyid, secret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        //自定义参数
        request.putQueryParameter("PhoneNumbers", phoneNum);
        request.putQueryParameter("SignName", "品优商城");
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", code);

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println("-->"+response.getData());
            System.out.println("-->"+response.getHttpStatus());
            //是否发送成功!
            return response.getHttpResponse().isSuccess();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return  false;
    }

}

