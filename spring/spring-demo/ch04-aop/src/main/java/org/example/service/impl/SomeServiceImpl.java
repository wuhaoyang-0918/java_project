package org.example.service.impl;

import org.example.service.SomeService;
import org.springframework.stereotype.Component;

/**
 * @author 昊洋
 * @date:2021-07-31 13:45
 * @PackageName: org.example.service.impl
 * @description:
 * @Version 1.0
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, int age) {
        System.out.println("业务方法doSome,创建商品订单");
    }

    @Override
    public String afterReturning(String name) {
        System.out.println("----目标方法被调用-----");
        return name;
    }

    @Override
    public String aroud(String name) {
        System.out.println("----目标方法被调用-----");
        return name;
    }

    @Override
    public void afterThrowing() {
        System.out.println("-----------"+(10/0));
    }

    @Override
    public void after() {
        System.out.println("----目标方法被调用-----");
    }
}
