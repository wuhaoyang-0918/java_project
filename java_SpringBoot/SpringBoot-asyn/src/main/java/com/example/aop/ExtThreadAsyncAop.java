package com.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author why
 * @date 2021/9/17 12:22
 * @PackageName com.example.aop
 * @description
 */
@Aspect
@Component
@Slf4j
public class ExtThreadAsyncAop {
    @Resource(name = "taskExecutor")
    private TaskExecutor taskExecutor;

    @Around(value = "@annotation(com.example.annotation.WhyAsyc)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(">环绕通知开始执行<");
       /* new Thread(()->{
            try {
                joinPoint.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }).start();*/
        taskExecutor.execute(()->{
            try {
                joinPoint.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        });
        log.info(">环绕通知结束执行<");
    }
}
