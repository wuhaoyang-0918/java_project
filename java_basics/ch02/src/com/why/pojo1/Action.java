package com.why.pojo1;

/**
 * @author why
 * @date 2021/9/6 18:41
 * @PackageName com.why.pojo1
 * @description
 */
public abstract class Action {
    private String userName="userName";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    static {
        System.out.println("父类静态代码块");
    }
    public Action(){
        System.out.println("抽象类构造方法");
    }
    public abstract void sho();

    public void show(){
        System.out.println("抽象类成员方法");
    }
}
