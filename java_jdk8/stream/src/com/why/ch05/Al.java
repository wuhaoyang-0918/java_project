package com.why.ch05;

import java.util.Arrays;

/**
 * @author why
 * @date 2021/9/23 21:33
 * @PackageName com.why.ch05
 * @description
 */
public class Al {
    public static void main(String[] args) {
       // IntStream stream = Arrays.stream(new int[]{1, 2, 3});
       Arrays.stream(new int[]{1, 2, 3})
               .map(n -> 2 * n + 1)// 对数值中的每个对象执行 2*n + 1 操作
               .average()// 求平均值
               .ifPresent(System.out::println);// 如果值不为空，则输出



    }
}
