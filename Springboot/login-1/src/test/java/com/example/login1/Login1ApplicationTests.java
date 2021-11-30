package com.example.login1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Login1ApplicationTests {
    /*短信发送*/
    @Test
    void contextLoads() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FxvmopGrPzJN3naoFaz", "RWQ3oJxkasfx6RaK7vOgg5MCFFeUf1");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        //自定义参数
        request.putQueryParameter("PhoneNumbers", "13246521057");
        request.putQueryParameter("SignName", "品优商城");
        request.putQueryParameter("TemplateCode", "SMS_196655221");
        //构建短信验证码
        String vscode= vscode();
        String code="{\"code\":\""+vscode+"\"}";
       /* String jocose= JSONObject.toJSONString(vscode);
        Map<String,Object> map=new HashMap<>();
        map.put("code",11111);*/
        request.putQueryParameter("TemplateParam", code);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    public static  String vscode(){
        String vScore = "";
        for (int i = 0; i < 6; i++) {
            vScore = vScore + (int)(Math.random() * 9);
        }
        return vScore;
    }

}
