package com.example.demo1.controll;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 昊洋
 * @date:2020-07-19 13:00
 * @description: Mycontroll
 * @version: 1.0
 */
@Controller
public class Mycontroll {
    @RequestMapping({"/", "/index"})
    public String idex(Model model) {
        model.addAttribute("msg", "hello");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/toLogin")
    public String tologin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            /*登录成功*/
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping("/nouth")
    public String Unauthorized() {//没有权限跳转的url
        return "未经授权无法访问此页面";
    }

    //注销
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        //subject.logout();
        Session session = subject.getSession();
        //清空session
        session.removeAttribute("loginuser");
        //session.setAttribute("loginuser", null);
        return "redirect:/index";
    }
}
