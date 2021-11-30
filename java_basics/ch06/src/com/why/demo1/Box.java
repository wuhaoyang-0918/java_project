package com.why.demo1;

/**
 * @author why
 * @date 2021/9/13 16:47
 * @PackageName com.why.demo1
 * @description
 */
public class Box {
    private int milk;
    private boolean state=false;


    public synchronized void put(int mike){
        //有牛奶等待消费
        if (state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //没有牛奶,就生产牛奶
        this.milk=mike;
        System.out.println("送奶工将第" + this.milk + "瓶奶放入奶箱");
        state=true;
        notifyAll();
    }

    public synchronized void get() {
        //没有牛奶,就等待生产
        if(!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //有牛奶,就消费牛奶
        System.out.println("用户拿到第" + this.milk + "瓶奶");
        state=false;
        notifyAll();
    }
}
