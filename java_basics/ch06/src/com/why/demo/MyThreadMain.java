package com.why.demo;

import com.why.threda.MyThread;

/**
 * @author why
 * @date 2021/9/13 10:39
 * @PackageName com.why.threda
 * @description
 */
public class MyThreadMain {
    public static void main(String[] args) {
        Thread myThread=new MyThread("线程一");
        MyThread myThread1=new MyThread("线程二");
        myThread.setPriority(10);
        System.out.println(myThread.getPriority());
        System.out.println(myThread1.getPriority());
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }

        myThread.start();
        myThread1.start();


    }
}
