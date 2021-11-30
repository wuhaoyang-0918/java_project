package com.why.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author why
 * @date 2021/10/21 16:12
 * @PackageName com.why.interceptor
 * @description
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         HttpSession session = request.getSession();
         String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)) {
            String contextPath = request.getServletContext().getContextPath();
            response.sendRedirect(contextPath+"/static/login.html");
        }else{
            return true;
        }
        return false;

    }
}
