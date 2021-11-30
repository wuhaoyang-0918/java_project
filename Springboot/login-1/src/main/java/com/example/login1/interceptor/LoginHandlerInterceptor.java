package com.example.login1.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 昊洋
 * @date:2020-07-15 23:19
 * @description: LoginHandlerInterceptor
 * @version: 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        System.out.println(username);
        if(username==null){
            //未登录
            request.setAttribute("msg","没有权限请先登录!");
            System.out.println("123456");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return  true;
        }

    }
    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
