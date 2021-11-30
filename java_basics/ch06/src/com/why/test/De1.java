package com.why.test;

/**
 * @author why
 * @date 2021/9/13 13:33
 * @PackageName com.why.test
 * @description
 */
public class De1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"------"+i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
