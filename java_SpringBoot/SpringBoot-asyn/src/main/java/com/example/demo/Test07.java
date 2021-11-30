package com.example.demo;

/**
 * @author why
 * @date 2021/9/19 1:58
 * @PackageName com.example.demo
 * @description
 */
public class Test07 {
    public static void main(String[] args) {
        new Test07().cal();
    }

    public synchronized void cal() {
        //synchronized this锁
        try {
            //主动释放对象锁synchronized(this),让线程变为等待阻塞
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
