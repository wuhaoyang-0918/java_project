package com.why.ch06;

import java.util.Arrays;
import java.util.List;

/**
 * @author why
 * @date 2021/9/24 16:40
 * @PackageName com.why.ch06
 * @description
 */
public class Distinct {
    public static void main(String[] args) {
        //去重
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
       numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);


    }
}
