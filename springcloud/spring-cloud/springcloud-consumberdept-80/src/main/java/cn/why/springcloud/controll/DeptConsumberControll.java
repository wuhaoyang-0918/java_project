package cn.why.springcloud.controll;

import com.why.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    private RestTemplate restTemplate; //提供多种便捷访问远程Http服务的方法,简单的Resuful服务模板
  //private static  final  String ReST_URL_PREFIX="http://localhost:8001";
  private static  final  String ReST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT";
  @PostMapping("/consumer/dept/add")
  public boolean add(Dept dept){
    return  restTemplate.postForObject(ReST_URL_PREFIX+"/dept/add",dept,boolean.class);
  }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
      return  restTemplate.getForObject(ReST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
  @RequestMapping("/consumer/dept/list")
  public List<Dept> list(){
    return  restTemplate.getForObject(ReST_URL_PREFIX+"/dept/list",List.class);
  }
}
