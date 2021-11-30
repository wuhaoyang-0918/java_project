package com.why.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author why
 * @date 2021/9/7 10:52
 * @PackageName com.why.test
 * @description
 */
public class Main1 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add(2,"3");//添加
        System.out.println(arrayList);

        arrayList.remove(2);//删除

        System.out.println(arrayList.get(0));//获取
        System.out.println(arrayList.size());//元素个数
        arrayList.set(0,"11");//修改
        System.out.println(arrayList);
        for (String s : arrayList) {
            System.out.println(s);

        }


    }

}
