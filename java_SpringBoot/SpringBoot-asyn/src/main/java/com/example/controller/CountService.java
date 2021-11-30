package com.example.controller;

import com.example.manage.MemberServiceAsync;
import com.example.manage.OrderManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author why
 * @date 2021/9/18 12:52
 * @PackageName com.example.controller
 * @description
 */

@RestController
@Slf4j
//@Scope(value = "prototype")
public class CountService {
    @Autowired
    private OrderManage orderManage;
    @Autowired
    private MemberServiceAsync memberServiceAsync;
    private int count = 0;

    @RequestMapping("/count")
    public synchronized String count() {
        log.info(">count<:" + (count++));
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "count";
    }
    @RequestMapping("/addOrder")
    public String addOrder() {
         log.info("<1>");
         orderManage.asyncLog();
    /*   new Thread(new Runnable() {
           @Override
           public void run() {
               orderManage.asyncLog();
           }
       }).start();*/
        log.info("<3>");
        return "3";
    }
    @RequestMapping("/addMember")
    public String addMember() {
        // 1.数据库插入数据
        log.info(">01<");
        memberServiceAsync.sms();
        log.info(">04<");
        return "用户注册成功";
    }

}
