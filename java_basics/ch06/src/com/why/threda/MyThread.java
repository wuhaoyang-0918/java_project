package com.why.threda;

/**
 * @author why
 * @date 2021/9/13 10:36
 * @PackageName com.why.threda
 * @description
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name); //调用父类的String参数的构造方法，指定线程的名称
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + "or"+super.getName());//获取线程名称
        }

    }
}
