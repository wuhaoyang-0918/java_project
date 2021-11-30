package com.why.pojo;

/**
 * @author why
 * @date 2021/9/4 14:39
 * @PackageName com.why.pojo
 * @description
 */
public class Student extends  Parent{
    private String name="Student";

    public void workStudent(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.getUserName());
    }
    @Override
    public void  sho1(){
        System.out.println("2222222");
        super.sho1();
    }
}
