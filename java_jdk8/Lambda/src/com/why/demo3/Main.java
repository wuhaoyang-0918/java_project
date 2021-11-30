package com.why.demo3;

/**
 * @author why
 * @date 2021/9/25 13:45
 * @PackageName com.why.demo3
 * @description
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(operator(1,2,(x,y)->x*y));
        System.out.println(operator(1,2,(x,y)->x-y));
        System.out.println(operator(1,2,(x,y)->x+y));
    }
    private static Integer operator(Integer x,Integer y,OperatorFunction<Integer,Integer> operatorFunction){
       return operatorFunction.operator(x,y);

    }
}
