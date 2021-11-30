package com.why.springcloud.service;

import com.why.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 昊洋
 * @date:2020-08-14 12:04
 * @description: DeptClientServiceFallbackFactory
 * @version: 1.0
 */
//降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {

                Dept dept=new Dept();
                dept.setDepton(id);
                dept.setDname("服务被关闭");
                dept.setDb_source("没有数据");
                return dept;
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
