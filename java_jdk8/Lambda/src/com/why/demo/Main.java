package com.why.demo;

import com.why.dao.UserDao;

/**
 * @author why
 * @date 2021/9/22 13:45
 * @PackageName com.why.demo
 * @description
 */
public class Main {
    public static void main(String[] args) {
         FuncationInterface funcationInterface=()->{
            System.out.println("<5>");
        };
        funcationInterface.get();

        ((FuncationInterface) () -> System.out.println("123")).get();


    }
}
