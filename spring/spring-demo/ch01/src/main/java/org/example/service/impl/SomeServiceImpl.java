package org.example.service.impl;

import org.example.service.SomeService;

/**
 * @author 昊洋
 * @date:2021-07-30 11:16
 * @PackageName: org.example.service.impl
 * @description:
 * @Version 1.0
 */
public class SomeServiceImpl implements SomeService {
    public  SomeServiceImpl(){
        System.out.println("对象创建");
    }
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome()");

    }
}
