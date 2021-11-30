package com.why.demo1;

/**
 * @author why
 * @date 2021/9/13 16:50
 * @PackageName com.why.demo1
 * @description
 */
public class Producer implements Runnable{
    private Box box;
    public Producer(Box box){
        this.box=box;
    }
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            box.put(i);
            
        }
    }
}
