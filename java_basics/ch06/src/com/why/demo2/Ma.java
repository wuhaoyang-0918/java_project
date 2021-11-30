package com.why.demo2;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @author why
 * @date 2021/9/14 13:13
 * @PackageName com.why.demo2
 * @description
 */
public class Ma {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1), (r, executor) -> {
            System.out.println("我是自定义拒绝策略");
        });


        threadPool.execute(() -> {
            System.out.println("被执行,线程名:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            System.out.println("被执行,线程名:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            System.out.println("被执行,线程名:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            System.out.println("被执行,线程名:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("当前线程数量:"+threadPool.getPoolSize());

        System.out.println("核心线程数:"+threadPool.getCorePoolSize());
        System.out.println("最大线程数"+threadPool.getMaximumPoolSize());


    }
}
