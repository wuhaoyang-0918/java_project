package com.why.pojo;

/**
 * @author why
 * @date 2021/9/4 14:39
 * @PackageName com.why.pojo
 * @description
 */
public class Parent {
    private String userName="Parent";
    private int age;

    public Parent(String userName, int age) {
        System.out.println("调用父类的有参构造方法");
        this.userName = userName;
        this.age = age;
    }
    public void  sho1(){
        System.out.println("111111111");
    }
    public Parent(){
        System.out.println("调用父类的无参构造方法");
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
