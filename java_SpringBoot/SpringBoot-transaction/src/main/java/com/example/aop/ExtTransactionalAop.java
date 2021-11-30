package com.example.aop;

import com.example.utils.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

/**
 * @author why
 * @date 2021/9/20 12:01
 * @PackageName com.example.aop
 * @description
 */
@Aspect
@Component
public class ExtTransactionalAop {
    @Autowired
    private TransactionUtils transactionUtils;

    @Around(value = "@annotation(com.example.annotation.AopAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint) {
        TransactionStatus status = null;
        Object proceed =null;
        try {
            status = transactionUtils.begin();
            proceed = joinPoint.proceed();
            transactionUtils.commit(status);
        } catch (Throwable e) {
            e.printStackTrace();
            if(status!=null)
                transactionUtils.rollback(status);
            return "failure";
        }

        return proceed;
    }

}
