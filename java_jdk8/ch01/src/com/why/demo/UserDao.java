package com.why.demo;

/**
 * @author why
 * @date 2021/9/22 12:36
 * @PackageName com.why.demo
 * @description
 */
public interface UserDao {
    default void print(){
        System.out.println("<print>");
    }
    static void printStatic(){
        System.out.println("<printStatic>");
    }
}
