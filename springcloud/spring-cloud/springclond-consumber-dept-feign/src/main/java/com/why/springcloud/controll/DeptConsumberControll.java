package com.why.springcloud.controll;

import com.why.springcloud.pojo.Dept;
import com.why.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 昊洋
 * @date:2020-08-11 18:43
 * @description: DeptConsumberControll
 * @version: 1.0
 */
@RestController
public class DeptConsumberControll {

 @Autowired
 private DeptClientService service=null;
  @PostMapping("/consumer/dept/add")
  public boolean add(Dept dept){

    return service.addDept(dept);
  }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
       return service.queryById(id);
    }
  @RequestMapping("/consumer/dept/list")
  public List<Dept> list(){
    return service.queryAll();

  }
}
