package com.why.pojo;

/**
 * @author why
 * @date 2021/9/6 16:45
 * @PackageName com.why.pojo
 * @description
 */
public class Ma {
    public static void main(String[] args) {
        //父类的引用指向子类
        //对象能调用哪些方法主要看左边的类型
        B b = new A();
        b.test1();
        ((A) b).test2();//强制装换


        B c = new C();
        c.test1();

        //A类能调用自己方法和继承过来的方法
        A a=new A();
        a.test2();
        a.test1();





    }
}
