package com.why.demo;

import com.why.threda.MyThread1;

/**
 * @author why
 * @date 2021/9/13 10:49
 * @PackageName com.why.demo
 * @description
 */
public class MyThread1Main {
    public static void main(String[] args) {
        Thread thread=new MyThread1();
        thread.setName("线程一");
        thread.start();
    }
}
