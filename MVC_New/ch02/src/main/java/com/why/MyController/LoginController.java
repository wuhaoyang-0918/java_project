package com.why.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author why
 * @date 2021/8/24 11:06
 * @PackageName com.why.MyController
 * @description
 */
@Controller
@RequestMapping("/user")
public class LoginController {


    /**
     * 成功页面
     */
    @RequestMapping("/success")
    public String index(){
        return "success";
    }
    /**
     *登录页面
     */
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }
    /**
     *执行登录
     */
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String pwd, Model model) throws Exception {
        session.setAttribute("user", username);
        model.addAttribute("userName",username);
        return "success";
    }
    /**
     * 退出
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/index.jsp";
}

}
