package com.example.demo;

/**
 * @author why
 * @date 2021/9/19 0:49
 * @PackageName com.example.demo
 * @description
 */
public class Test05 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        }, "线程一");
        thread.setDaemon(true);
        thread.start();


        System.out.println("我是主线程main");
    }
}
