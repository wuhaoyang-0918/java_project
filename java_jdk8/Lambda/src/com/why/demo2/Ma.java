package com.why.demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author why
 * @date 2021/9/22 15:07
 * @PackageName com.why.demo2
 * @description
 */
public class Ma {
    public static void main(String[] args) {
        //集合排序
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User(3));
        arrayList.add(new User(1));
        arrayList.add(new User(2));
        arrayList.sort(((o1, o2) -> o1.getId() - o2.getId()));
        arrayList.forEach(System.out::println);
      //  arrayList.forEach(stu -> System.out.println(stu));

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort((a, b) -> b.compareTo(a));
        names.forEach(System.out::println);
    }
}
