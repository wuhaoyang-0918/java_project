package com.why.pojo;

/**
 * @author why
 * @date 2021/9/4 14:39
 * @PackageName com.why.pojo
 * @description
 */
public class Thacher extends  Parent{

    public Thacher() {
        System.out.println("子类无参构造方法");
    }

    public Thacher(String userName, int age) {
        //给父类有参构造方法赋值
        super(userName, age);
    }

    public void workStudent(){
        System.out.println("老师工作");
    }

}
