package com.why.demo1;

/**
 * @author why
 * @date 2021/9/13 16:52
 * @PackageName com.why.demo1
 * @description
 */
public class Customer implements Runnable{
    private Box box;
    public Customer(Box box){
        this.box=box;
    }

    @Override
    public void run() {
        box.get();
    }
}
