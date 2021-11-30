package com.example.demo;

/**
 * @author why
 * @date 2021/9/18 15:02
 * @PackageName com.example
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

    public static void main(String[] args) {
        Thread thread=new Thread(new De1(),"线程一");
        Thread thread1=new Thread(new De1(),"线程二");
        thread.start();

        try {
            thread.join();//线程一走完再线程二
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
    }
    }

