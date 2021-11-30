package com.why.ch07;

import com.why.ch07.Empty.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author why
 * @date 2021/9/26 10:06
 * @PackageName com.why.ch07.Empty
 * @description
 */
public class FilterMap {
    public static void main(String[] args) {
        // 筛选员工中工资高于8000的人，并形成新的集合
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        List<String> collect = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);

       // 将员工的薪资全部增加1000。改变原来员工集合的方式
        personList.stream().map(person->{person.setSalary(person.getSalary() + 10000);return person;}).collect(Collectors.toList()).forEach(System.out::println);

    }
}
