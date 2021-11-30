package com.example.demo;

/**
 * @author why
 * @date 2021/9/18 15:15
 * @PackageName com.example.demo
 * @description
 */
public class Test01 {
    private final Object object = new Object();

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        test01.print();
        test01.sf();


    }

    public void print() {
        new Thread(()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName()+">1<");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+">2<");
            }
        }).start();
       /* try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
            synchronized (object){
                object.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
    public void  sf(){
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
            synchronized (object){
                object.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
