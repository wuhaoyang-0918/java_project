package com.example.demo;

/**
 * @author why
 * @date 2021/9/19 0:03
 * @PackageName com.example.demo
 * @description
 */
public class Test04 {
    public static void main(String[] args) {
        //ti run方法执行完毕 唤醒--t2正在等待 底层会封装唤醒
        Thread t1=new Thread(()->{System.out.println(Thread.currentThread().getName()+",线程执行");},"线程一");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //ti.wait();t2 调用t1(this锁).wait() 主动释放this锁 同时t2线程变为阻塞状态
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+",线程执行");
            }
        },"线程二");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+",线程执行");
            }
        },"线程三");
        t1.start();
        t2.start();
        t3.start();
    }
}
