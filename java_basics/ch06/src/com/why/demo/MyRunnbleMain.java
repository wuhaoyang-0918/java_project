package com.why.demo;

import com.why.threda.MyRunnble;

/**
 * @author why
 * @date 2021/9/13 11:03
 * @PackageName com.why.demo
 * @description
 */
    public class MyRunnbleMain {
        public static void main(String[] args) {
            Thread thread=new Thread(new MyRunnble(),"线程一");

            thread.start();

        }
    }
