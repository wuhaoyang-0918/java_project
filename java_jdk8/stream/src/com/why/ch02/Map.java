package com.why.ch02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author why
 * @date 2021/9/25 14:37
 * @PackageName com.why.ch02
 * @description
 */
public class Map {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a1", "a2", "a3");
        list.stream().map(s -> "我是:" + s).collect(Collectors.toList()).forEach(System.out::println);

        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> collect = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> collect1 = intList.stream().map(x -> x + 3).collect(Collectors.toList());
        collect1.forEach(System.out::println);
    }
}
