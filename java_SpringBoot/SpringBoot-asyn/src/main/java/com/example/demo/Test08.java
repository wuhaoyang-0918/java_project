package com.example.demo;

/**
 * @author why
 * @date 2021/9/19 13:20
 * @PackageName com.example.demo
 * @description
 */
public class Test08 implements Runnable{
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

    public static void main(String[] args) {
        Thread thread=new Thread(new Test08(),"线程一");
        Thread thread1=new Thread(new Test08(),"线程二");
        thread.start();
        thread1.start();
    }
}


