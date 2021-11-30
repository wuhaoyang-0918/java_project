package org.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 昊洋
 * @date:2021-07-31 10:14
 * @PackageName: org.example.demo
 * @description:
 * @Version 1.0
 */
@PropertySource(value ={"classpath:config-1.properties"},encoding = "UTF-8")
@ComponentScan
public class Config {
}
