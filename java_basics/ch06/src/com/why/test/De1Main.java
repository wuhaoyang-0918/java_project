package com.why.test;

import com.why.threda.MyRunnble;

/**
 * @author why
 * @date 2021/9/13 13:36
 * @PackageName com.why.test
 * @description
 */
public class De1Main {
    public static void main(String[] args) {
        Thread thread=new Thread(new De1(),"线程一");
        Thread thread1=new Thread(new De1(),"线程二");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
    }
}
