package com.why.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 昊洋
 * @date:2021-08-17 10:02
 * @PackageName: com.why.controll
 * @description:
 * @Version 1.0
 */
@Controller
public class MyControll {
    /**
     *  控制器方法返回是ModelAndView实现转发forward
     *  语法： mv.setViewName("forward:视图完整路径")
     *
     *  forward特点：不和视图解析器一同工作的，就当项目中没有视图解析器
     */
    @RequestMapping(value ="/doForward.do")
    public ModelAndView doForward(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ModelAndView mv  = new ModelAndView();
        mv.addObject("msg", "处理了some.do请求");
        mv.addObject("fun", "执行了doSome方法");
        //mv.setViewName("forward:/WEB-INF/views/show.jsp");
          mv.setViewName("forward:/hello.jsp");
        return mv;

    }
    /**
     * 当控制器方法返回ModelAndView实现重定向
     * 语法： mv.setViewName("redirect:视图完整路径)
     * redirect特点：不和视图解析器一同工作，就当项目中没有视图解析器
     *
     * 框架提供的重定向的功能
     * 1. 框架可以实现两次请求之间的数据传递， 把第一个请求中的Model里面
     *    简单类型的数据，转为字符串，附加到目标页面的后面，做get参数传递。
     *    可以在目标页面中获取参数值使用。
     *
     * 2.在目标页面中，可以使用 ${param.参数名} 获取参数的值
     */
    @RequestMapping("/doRedirect.do")
    public ModelAndView doRedirect(String name, Integer age){
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("redirect:/other.jsp"); //http://localhost:8080/demo2/other.jsp?myname=li&myage=1

        //重定向不能访问/WEB-INF
        //mv.setViewName("redirect:/WEB-INF/view/show.jsp");
        return mv;
    }
}
