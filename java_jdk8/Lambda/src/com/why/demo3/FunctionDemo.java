package com.why.demo3;

import java.util.function.Function;

/**
 * @author why
 * @date 2021/9/25 14:00
 * @PackageName com.why.demo3
 * @description
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> fun=(num)->num+20;
        System.out.println(fun.apply(10));
    }
}
