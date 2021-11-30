package com.example.demo;

/**
 * @author why
 * @date 2021/9/19 1:45
 * @PackageName com.example.demo
 * @description
 */
public class Test06 extends Thread {
    public Test06(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i == 30) {
                System.out.println(Thread.currentThread().getName() + ",释放cpu执行权");
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "," + i);
        }
    }

    public static void main(String[] args) {
        new Test06("mayikt01").start();
        new Test06("mayikt02").start();
    }
}
