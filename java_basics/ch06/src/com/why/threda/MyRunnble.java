package com.why.threda;

/**
 * @author why
 * @date 2021/9/13 11:01
 * @PackageName com.why.threda
 * @description
 */
public class MyRunnble implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
