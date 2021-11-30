package com.java.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 昊洋
 * @date:2021-08-17 12:56
 * @PackageName: com.java.handler
 * @description:
 * @Version 1.0
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name="";
        Object userName = request.getSession().getAttribute("userName");
        if (userName != null) {
            name=(String)userName;
        }
        if ("zs".equals(name)){
            return  true;
        }else {
            request.getRequestDispatcher("tips.jsp").forward(request,response);//转发
              //response.sendRedirect("tips.jsp");//重定向
            return  false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}
}
