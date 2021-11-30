package com.why.ch07;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author why
 * @date 2021/9/26 10:16
 * @PackageName com.why.ch07
 * @description
 */
public class Comparator {
    public static void main(String[] args) {
        //案例一：获取String集合中最长的元素。
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(java.util.Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());

    }
}
