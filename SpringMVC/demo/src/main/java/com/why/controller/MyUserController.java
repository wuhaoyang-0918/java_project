package com.why.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.why.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-15 11:55
 * @PackageName: com.why.controller
 * @description: 创建控制器对象,放到Springmvc的容器中
 * @Version 1.0
 */
@Controller
public class MyUserController {
    /**
     * 更下面一样
     */
   /* @RequestMapping("/doSom")
        public ModelAndView doSom(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","789");
        modelAndView.setViewName("index");
        //把数据放到request作用域
        return  modelAndView;
    }*/
    @RequestMapping(value = {"/doSom","/doSon"})
    public String doSom(Model model, HttpServletRequest request){
        request.setAttribute("msg","111213");
        model.addAttribute("msg", "78910");
        return  "index";
    }

    /**
     * 不指定get post都支持
     */
    @RequestMapping(value ="/doSim",method = RequestMethod.GET)
    public String doSim(Model model,@RequestParam(value = "nmea",required = false) String name){
        model.addAttribute("name", name);
        return "index1";
    }
    /**
     * 获取请求参数
     * @RequestParam 不加也可以接受到表单的参数
     */
    @PostMapping("/login")
    @ResponseBody
    public  String login(@RequestParam("name") String name,@RequestParam("age")Integer age){
        System.out.println("获取参数--》"+name+"--"+age);
         return "Session";
}
    @PostMapping("/login1")
    @ResponseBody
    public  String login1(@RequestBody User user) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        System.out.println(s);
        return "Session";
    }

    /**
     *发起get方式ajax请求
     */
   /* @RequestMapping("/ajx")
     @ResponseBody
    public  String getAjx(User user) {
       *//* ObjectMapper objectMapper=new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);*//*
        System.out.println("-------------------");
       *//* JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("age",age);*//*
       *//* String s = jsonObject.toJSONString();*//*
        return JSON.toJSONString(user);
    }*/
    /**
     *发起POST方式ajax请求
     */
    @PostMapping("/ajx")
    @ResponseBody
    public  String postAjx(@RequestBody User user) {

        return JSON.toJSONString(user);
    }
    /**
     *返回json数组
     * 使用实现类MappingJackson2HttpMessageConverter.执行他的write()方法，
     * 设置的content-type: application/json;charset=utf-8
     */
    @RequestMapping("/ajx")
    @ResponseBody
    public List<User> getArrayAjx(User user) {

        List<User> list=new ArrayList<>();
        User user1 = new User("zs",11);
        User user2 = new User("ls",12);
        list.add(user1);
        list.add(user2);
        return list;
    }
    /**
     * 返回String类型
     * 解决中文乱码produces属性,指定content-type:告诉游览器怎么显示服务器返回的数据
     * 1. 框架使用的StringHttpMessageConverter
     * 2. StringHttpMessageConverter使用的是text/plain;charset=ISO-8859-1。
     */
    @RequestMapping(value = "ajxS",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getStringAjx(){
    return "吴昊洋";
}
    @RequestMapping("/usr")
    public String log(){
        return "index";
    }
}
