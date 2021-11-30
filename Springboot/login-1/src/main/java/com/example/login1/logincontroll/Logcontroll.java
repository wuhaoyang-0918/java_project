package com.example.login1.logincontroll;


import com.example.login1.service.SendSms;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 昊洋
 * @date:2020-07-14 13:42
 * @description: Logcontroll
 * @version: 1.0
 */
@Controller
@CrossOrigin //跨域支持
public class Logcontroll {
    @Autowired
    private SendSms sendSms;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }
   /* @ResponseBody
    @RequestMapping({"/login.html"})
    public Object Login(@RequestParam(value = "phone")String phone){
        //构建短信验证码
        String vscode= vscode();
        String code="{\"code\":\""+vscode+"\"}";
        boolean send = sendSms.send(phone,code);
        //return  send==true ? "success":"error";
        return  send;
    }*/
    /**
     * @Author  昊洋
     * @Description 随机生产6位二维码
     * @Date   2020/7/15 15:56
     * @Param  []
     * @return java.lang.String
     **/

    public static  String vscode(){
        String vScore = "";
        for (int i = 0; i < 6; i++) {
            vScore = vScore + (int)(Math.random() * 9);
        }
        return vScore;
    }
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("username",username);
            //登录成功需要重定向
            return "redirect:/dashboard.html";
        }else {
            map.put("msg","用户名密码错误");
        }
        return  "index";
    }
    /**
     * dashboard.html页面
     */
    @RequestMapping("/dashboard.html")
    public String dashboard(){
        return "dashboard";
    }
    @RequestMapping("/user/login/dashboard.html")
    public String dashboard1(){
        return "dashboard";
    }

}
