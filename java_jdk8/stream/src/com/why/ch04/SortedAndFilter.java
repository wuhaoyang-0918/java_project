package com.why.ch04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author why
 * @date 2021/9/23 20:56
 * @PackageName com.why.ch04
 * @description
 */
public class SortedAndFilter {
    public static void main(String[] args) {
        //Sorted 排序+filter 过滤
        List<String> list = new ArrayList<>();
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))//以a开头
                .forEach(System.out::println);
        System.out.println("--------------");
        // Map 转换
        list.stream()
                .map(String::toUpperCase)        //转为大小map     方法内部会自动进行空校验：
                .sorted((a, b) -> b.compareTo(a))//字符串降序
                .forEach(System.out::println);
        System.out.println("---------------------");


    }
}
