package com.why.test2;

import java.util.*;

/**
 * @author why
 * @date 2021/9/9 14:55
 * @PackageName com.why.test2
 * @description
 */
public class Ma {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        System.out.println(map.get("1"));
        //遍历第一种方法
      /*  Set<String> set = map.keySet();//获取所以键的集合
        for (String s : set) {
            System.out.println( map.get(s));

        }*/
        //遍历第二种方法(推荐)
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

       /* Collection<String> values = map.values();//获取所以值的集合
        for (String value : values) {
            System.out.println(value);
        }*/


    }
}
