package com.why.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author why
 * @date 2021/9/13 14:48
 * @PackageName com.why.test
 * @description
 */
public class Ticket implements Runnable {
    private static int ticket = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(50);
                    System.out.println(Thread.currentThread().getName() + "正在卖:" + ticket);
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
