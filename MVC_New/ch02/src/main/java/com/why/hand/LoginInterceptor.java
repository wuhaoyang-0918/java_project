package com.why.hand;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author why
 * @date 2021/8/24 11:27
 * @PackageName com.why.hand
 * @description
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        // 如果用户已登陆也放行
        if(session.getAttribute("user") != null) {
            return true;
        }
       /*   //提交登录  放行
        if(request.getRequestURI().contains("login")) {
            return true;
        }*/

        // 用户没有登陆跳转到登陆页面
        System.out.println("--------------------------");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

        return false;
    }
}
