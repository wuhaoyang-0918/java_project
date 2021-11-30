package com.why.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.why.springcloud.pojo.Dept;
import com.why.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 昊洋
 * @date:2020-08-11 14:57
 * @description: 提供Restful服務
 * @version: 1.0
 */
@RestController
public class DeptControll {
    @Autowired
    private DeptService deptService;
    //获取一些配置的信息，得到具体的微服务!



    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if(dept==null){
            throw  new RuntimeException("不存在该用户");
        }
        return  dept;
    }
    //备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        //服务降级
        //返回当前人数太多,请稍后查看
        Dept dept=new Dept();
        dept.setDepton(id);
        dept.setDname("没有找到对应信息");
        dept.setDb_source("no this database is MySQL");
        return dept;

    }


}
