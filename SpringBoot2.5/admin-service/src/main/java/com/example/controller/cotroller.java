package com.example.controller;

import com.example.pojo.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author why
 * @date 2021/10/26 13:34
 * @PackageName com.example
 * @description
 */
@RestController
public class cotroller {
    @GetMapping("/usr/{id}/owner/{name}")
    public Map<String, Object> show(@PathVariable("id") Integer id,
                                    @PathVariable("name") String name,
                                    @PathVariable Map<String, String> pv,
                                    @RequestHeader("User-Agent") String userAgent,
                                    @RequestHeader Map<String, String> header,
                                    @RequestParam("age") Integer age,
                                    @RequestParam("inters") List<String> inter,
                                    String [] inters,
                                    User user,
                                    @RequestParam Map<String, String> map1,
                                    @CookieValue("Idea-da34cd36") String coolie,
                                    @CookieValue("Idea-da34cd36") Cookie cookie


    )
    {

        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("header",header);
        map.put("age",age);
        map.put("inters数组",inters);
        map.put("inter集合",inter);
        map.put("user",user);
        map.put("map1",map1);
        map.put("Idea-da34cd36",coolie);
        map.put("名称"+cookie.getName(),cookie.getValue());






        return map;
    }
}
