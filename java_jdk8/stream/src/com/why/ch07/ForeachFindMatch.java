package com.why.ch07;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author why
 * @date 2021/9/25 17:30
 * @PackageName com.why.ch07
 * @description
 */
public class ForeachFindMatch {

    public static void main(String[] args) {
        //遍历/匹配（foreach/find/match）
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> first = list.stream().filter(x -> x > 6).findFirst();
        System.out.println(first.get());
        // 匹配任意（适用于并行流）
        Optional<Integer> first1 = list.parallelStream().filter(x->x>6).findAny();
        System.out.println(first1.get());
        // 是否包含符合特定条件的元素
        boolean b = list.stream().anyMatch(x -> x > 6);
        System.out.println(b);

    }
}
