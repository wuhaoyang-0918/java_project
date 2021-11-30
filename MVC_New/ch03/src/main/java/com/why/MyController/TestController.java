package com.why.MyController;

import com.why.pojo.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author why
 * @date 2021/8/24 22:23
 * @PackageName com.why.MyController
 * @description
 */
@Controller
public class TestController {
    @RequestMapping("/hello")
    public String helloWorld(String userName,HttpServletRequest request,@CookieValue("JSESSIONID") String cookies){
        String userName1 = request.getParameter("userName");
        System.out.println("-----"+cookies);
        return "Hello";
    }
    @RequestMapping("/a")
    public String helloWorld(HttpServletRequest request,@RequestHeader("Host") String host){
        //先检测请求报文种有没有JSESSIONID的cookies,如果没有就创建Session并将JSESSIONID通过响应报文返回给客户端
        //cookies生命周期游览器开启到关闭
        HttpSession session = request.getSession();
        session.setAttribute("sess","why2");
        ServletContext application = request.getServletContext();
        ServletContext context = session.getServletContext();
        context.setAttribute("sessionApplication","sessionApplication");
        application.setAttribute("requestApplication","requestApplication");
        return "a";
    }

        @RequestMapping(value="/order",method= RequestMethod.POST)
       @ResponseBody
        public String testRequestEntity(RequestEntity<String> requestEntity){
            System.out.println("requestHeader:"+requestEntity.getHeaders().getHost());
            System.out.println("requestBody:"+requestEntity.getBody());
            return "success";
        }
      @RequestMapping("/hello1")
       public String helloWorld(){
        return "Hello";
       }

    @RequestMapping(value="/order1")
    @ResponseBody
    public String testRestPut1(@RequestBody User user){
        System.out.println(user);
        return "aaa";
    }

}
