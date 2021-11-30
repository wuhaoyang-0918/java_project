package com.java.MyController;

import com.java.exception.AgeException;
import com.java.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 昊洋
 * @date:2021-08-17 10:43
 * @PackageName: com.java.MyController
 * @description:
 * @Version 1.0
 */
@Controller
public class MyController {
    @RequestMapping(value ="/some.do")
    public ModelAndView doSome(String name, Integer age) throws Exception {
        //抛出异常
        if(!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }

        if(age == null || age > 80){
            throw new AgeException("年龄太大了");
        }

        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        //返回结果
        return mv;
    }
}
