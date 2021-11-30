package com.company.Thread;

/**
 * @author 昊洋
 * @date:2020-08-28 10:08
 * @PackageName: com.company.Thread
 * @ClassName: MyThread
 * @description:
 * @version: 1.0
 */
public class MyThread implements   Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);

        }
    }
}
