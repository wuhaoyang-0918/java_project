package com.why.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author why
 * @date 2021/10/21 16:09
 * @PackageName com.why.MyController
 * @description
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String longin(String username, String password, HttpSession session){
        session.setAttribute("username",username);
        return "/WEB-INF/page/success.jsp";
    }

    @RequestMapping("/test")
    public String test(){
        return "/WEB-INF/page/success.jsp";
    }

}

