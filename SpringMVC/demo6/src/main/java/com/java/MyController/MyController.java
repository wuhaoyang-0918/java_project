package com.java.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author 昊洋
 * @date:2021-08-17 12:52
 * @PackageName: com.java.MyController
 * @description:
 * @Version 1.0
 */
@Controller
public class MyController {
    @RequestMapping(value ="/some.do")
    public ModelAndView doSome(String name, Integer age)  {
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }
}
