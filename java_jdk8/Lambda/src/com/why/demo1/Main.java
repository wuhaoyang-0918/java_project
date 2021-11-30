package com.why.demo1;

import java.util.ArrayList;

/**
 * @author why
 * @date 2021/9/22 14:46
 * @PackageName com.why.demo1
 * @description
 */
public class Main {
    public static void main(String[] args) {
        //集合遍历
   ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.forEach(System.out::println);
        arrayList.forEach((stu) -> System.out.println(stu));

    }
}
