package com.why.demo3;

import java.util.function.BiFunction;

/**
 * @author why
 * @date 2021/9/25 14:11
 * @PackageName com.why.demo3
 * @description
 */
public class BifunctionDemo {
    public static void main(String[] args) {
        System.out.println(operator(1,2, Integer::sum));
    }
    private static  Integer operator(Integer x,Integer y,BiFunction<Integer,Integer,Integer> biFunction){
      return   biFunction.apply(x,y);
    }
}
