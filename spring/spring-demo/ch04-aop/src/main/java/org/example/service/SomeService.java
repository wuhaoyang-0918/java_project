package org.example.service;

/**
 * @author 昊洋
 * @date:2021-07-31 13:43
 * @PackageName: org.example.service
 * @description:
 * @Version 1.0
 */
public interface SomeService {
    /**
     * 前置通知
     * @param name
     * @param age
     */
    void doSome(String name,int age);

    /**
     *  后置通知
     * @param name
     * @return
     */
    String afterReturning(String name);

    /**
     * 环绕通知
     * @param name
     * @return
     */
    String aroud(String name);

    /**
     * 异常通知
     */
    void  afterThrowing();

    /**
     * 最终通知
     */
    void  after();
}
