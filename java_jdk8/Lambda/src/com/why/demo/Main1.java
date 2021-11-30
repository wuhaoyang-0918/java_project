package com.why.demo;

import com.why.dao.UserDao;

/**
 * @author why
 * @date 2021/9/22 13:57
 * @PackageName com.why.demo
 * @description
 */
public class Main1 {
    public static void main(String[] args) {
        FuncationInterface1 funcationInterface1 = (i, j) -> {
            return "" + i + j;
        };
        System.out.println(funcationInterface1.get(1, 2));

        System.out.println(((FuncationInterface1) (i, j) -> "" + i + j).get(1, 2));



    }
}
