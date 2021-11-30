package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author why
 * @date 2021/9/29 20:53
 * @PackageName com.example.pojo
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
    /**
     * ip
     */
    private String ip;
    /**
     * Http方法
     */
    private String httpMethod;
    /**
     * url
     */
    private  String url;
    /**
     * 请求参数key
     */
    private Object[] args;
    /**
     * 请求方法完整路径
     */
    private String classMethod;

    /**
     * 请求参数key value
     */
    private Map<String, String> params;
    /**
     * 执行时间
     */
    private Long execTime;
}
