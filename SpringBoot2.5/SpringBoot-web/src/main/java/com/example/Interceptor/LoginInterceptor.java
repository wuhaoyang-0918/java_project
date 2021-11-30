package com.example.Interceptor;

import com.example.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author why
 * @date 2021/10/23 10:47
 * @PackageName com.example.Interceptor
 * @description
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    {
        //获取请求头中的token
        String token = request.getHeader("token");
        //判断token是否为空，如果为空也代表未登录 提醒重新登录（401）
        if (!StringUtils.hasText("token")) {
            throw new RuntimeException("未登录,请登陆后重试!");
            //response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
           // return false;
        }
        //解析token看看是否成功
        try {
            Claims claims = JwtUtil.parseJWT(token);
            //String subject = claims.getSubject();
           // System.out.println("===>"+subject);
        } catch (Exception e) {
            e.printStackTrace();
            //解析失败(没有登录)或者token超时(登录超时需要重新登录)都会抛出异常,提醒重新登录（401）
           // response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
          //  return false;
            throw new RuntimeException("未登录,请登陆后重试!");
        }

        return true;
    }
}
