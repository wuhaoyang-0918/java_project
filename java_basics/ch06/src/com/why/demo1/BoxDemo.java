package com.why.demo1;

/**
 * @author why
 * @date 2021/9/13 16:56
 * @PackageName com.why.demo1
 * @description
 */
public class BoxDemo {
    public static void main(String[] args) {
        Box box=new Box();
        Producer producer=new Producer(box);
        Customer customer=new Customer(box);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(customer);
        t1.start();
        t2.start();
    }
}
