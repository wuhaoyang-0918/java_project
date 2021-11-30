package com.why.ch06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author why
 * @date 2021/9/24 17:32
 * @PackageName com.why.ch06
 * @description
 */
public class MaxAndMin {
    public static void main(String[] args) {
        //最大值和最小值
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Optional<Integer> max2 = nums.stream().max(Integer::compareTo);
        Optional<Integer> maxOption = nums.stream().reduce(Integer::max);
        Optional<Integer> minOption = nums.stream().reduce(Integer::min);
        System.out.println(maxOption.get()+"------"+max2.get());
        System.out.println(minOption.get());

        System.out.println("---------------------------------------------");

        List<Flower> flowerList = Arrays.asList(
                new Flower("red", 10),
                new Flower("yellow", 7),
                new Flower("pink", 8),
                new Flower("yellow", 8),
                new Flower("red", 12));
        //最大值
        Optional<Flower> max = flowerList.stream().max(Comparator.comparing(Flower::getId));
        Optional<Flower> mx = flowerList.stream().max(Comparator.comparingInt(Flower::getId));
        Optional<Flower> max1 = flowerList.stream().max(((o1, o2) -> o1.getId()- o2.getId()));
        System.out.println("最大值："+max.get().getId()+"---"+max1.get().getId()+"---"+mx.get().getId());

        //最小值
        Optional<Flower> min = flowerList.stream().min(Comparator.comparing(Flower::getId));
        Optional<Flower> min1 = flowerList.stream().min(((o1, o2) -> o1.getId()- o2.getId()));
        System.out.println(min.get().getId()+"---"+min1.get().getId());
    }
}
