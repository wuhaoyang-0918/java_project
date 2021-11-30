package com.why.demo;

/**
 * @author why
 * @date 2021/9/13 11:20
 * @PackageName com.why.threda
 * @description
 */
public class internalClass {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        },"线程一").start();
    }
    }

