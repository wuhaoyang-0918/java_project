package com.why.pojo1;

/**
 * @author why
 * @date 2021/9/6 18:41
 * @PackageName com.why.pojo1
 * @description
 */
public class Us extends  Action{
    static {
        System.out.println("子类静态代码块");
    }
    public Us(){
        System.out.println("子类构造方法");
    }
    @Override
    public void sho() {
        System.out.println("实现抽象类的方法");
    }

    @Override
    public void show() {
        super.show();
    }
}
