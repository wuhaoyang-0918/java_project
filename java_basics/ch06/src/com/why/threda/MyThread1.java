package com.why.threda;

/**
 * @author why
 * @date 2021/9/13 10:47
 * @PackageName com.why.threda
 * @description
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

    }
}
