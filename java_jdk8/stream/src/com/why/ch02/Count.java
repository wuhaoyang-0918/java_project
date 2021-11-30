package com.why.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author why
 * @date 2021/9/23 20:58
 * @PackageName com.why.ch02
 * @description
 */
public class Count {
    public static void main(String[] args) {
        // 先对 list 中字符串开头为 b 进行过滤，让后统计数量
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        long b = stringCollection.stream()
                .filter((s) -> s.startsWith("b"))
                .count();
        System.out.println(b);


    }
}
