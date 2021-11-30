package com.why.pojo;

import java.time.Period;

/**
 * @author why
 * @date 2021/9/6 17:54
 * @PackageName com.why.pojo
 * @description
 */
public class Person {
    //创建对象加载比构造方法还快
    {
        System.out.println("匿名代码块");
    }
    //只执行一次,再new也不会调用
    static {
        System.out.println("静态代码块");
    }
    public Person(){
        System.out.println("构造代码块");
    }
    public void sho(){
        System.out.println("person");
    }
}
