package com.why.pojo;

/**
 * @author why
 * @date 2021/9/7 16:39
 * @PackageName com.why.pojo
 * @description
 */
public class User extends Anmid{
    public User(){
        System.out.println("子类无参构造方法");
    }
    public User(int age) {
        super(age);
    }
}
