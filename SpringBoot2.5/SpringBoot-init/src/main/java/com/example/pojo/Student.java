package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author why
 * @date 2021/10/21 20:16
 * @PackageName com.example.pojo
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String lastName;
    private Integer age;
    private Boolean boss;

    private Date birthday;
    private Map<String,String> maps;
    private Map<String,String> maps2;
    private List<Dog> list;

    private Dog dog;
    private String[] arr;
    private String[] arr2;

    private Map<String,Dog> dogMap;
}
