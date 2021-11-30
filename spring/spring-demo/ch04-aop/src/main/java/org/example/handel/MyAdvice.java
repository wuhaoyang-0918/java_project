package org.example.handel;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

/**
 * @author 昊洋
 * @date:2021-07-31 17:59
 * @PackageName: org.example.handel
 * @description:
 * @Version 1.0
 */
public class MyAdvice {
    /**
     * 前置通知
     * joinPoint 一定要在第一个参数
     * @param joinPoint
     */
    public  void  before(JoinPoint joinPoint){
        System.out.println("方法定义"+joinPoint.getSignature());
        System.out.println("方法定义"+joinPoint.getSignature().getName());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("前置通知,切面功能在目标方法之前执行"+new Date());
    }

    /**
     *  能获取到目标方法执行结果
     *  不会影响目标方法的执行
     *  1.方法返回是String Integer Long等基本类型
     *    在后置通知中，修改返回值，是不会影响目标方法最后调用的结果
     *  2，方法返回是引用类型
     *     在后置通知中，修改返回值，是影响目标方法最后调用的结果
     * @param res
     */

    public  void  afterReturn(Object res){
        System.out.println("后置通知---"+res);
    }

    /**
     * 环绕通知
     * @return
     * 1.在目标方法的前和后都能增强功能
     * 2.控制目标方法是否执行          Object proceed = point.proceed();//执行目标方法，不加不执行
     * 3.修改目标方法结果  就是return  proceed
     */

    public Object around(ProceedingJoinPoint point) throws Throwable {
       System.out.println("环绕前");
       Object proceed = point.proceed();//执行目标方法

       System.out.println("环绕后");
       return  proceed;
   }

    /**
     * 目标方法抛出异常执行 没有异常不执行
     * 能获取到异常信息
     * @param ex
     */

    public  void  afterThrowing(Exception ex){
        System.out.println("----->"+ex.getMessage());
    }

    /**
     * 目标方法后执行
     * 无论是否异常都能执行
     */

    public void  after(){
        System.out.println("------》最终增强");
    }
}
