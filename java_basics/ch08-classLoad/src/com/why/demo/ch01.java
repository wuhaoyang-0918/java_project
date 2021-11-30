package com.why.demo;

/**
 * @author why
 * @date 2021/9/19 15:39
 * @PackageName com.why.demo
 * @description
 */
public class ch01 {
    public static void main(String[] args) {

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);


    }
}
