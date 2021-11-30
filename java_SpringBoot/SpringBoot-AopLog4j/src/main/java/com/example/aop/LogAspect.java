package com.example.aop;

import com.example.pojo.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author why
 * @date 2021/9/29 20:31
 * @PackageName com.example.aop
 * @description
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.example.controller..*.*(..))")
    public void log() {}

    /**
     * 环绕增强
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("log()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result =  result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point, time);
        } catch (Throwable e) {
            log.info("程序出错了,异常：{}",e);
        }
        return result;

    }

    /**
     * 保存日志
     * @param joinPoint
     * @param time
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String httpMethod = request.getMethod();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+"()";
        Object[] args = joinPoint.getArgs();
        Map<String, String[]> params = request.getParameterMap();
        Map<String,String> map = new HashMap<>();
        for (Map.Entry<String,String[]> temp : params.entrySet()) {
            map.put(temp.getKey(), Arrays.toString(temp.getValue()));
        }
        SysLog sysLog=new SysLog(ip,httpMethod,url,args,classMethod,map,time);
         log.info("Request : {}", sysLog);
    }

    /**
     * 后置增强
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "log()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().getName();
        log.info("方法{}执行完毕，Result : {}", method, result);
    }

    /**
     * 异常增强
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(pointcut = "log()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        String method = joinPoint.getSignature().getName();
        log.error("执行方法：{}出错，异常为：{}", method, ex);
    }


}
