package com.java.handle;

import com.java.exception.AgeException;
import com.java.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 昊洋
 * @date:2021-08-17 10:56
 * @PackageName: com.java.handle
 * @description:
 * @Version 1.0
 */
@ControllerAdvice(basePackages = {"com.java.MyController"})
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NameException.class)
    public ModelAndView  doNameException(Exception e){
        ModelAndView mv  = new ModelAndView();
        mv.addObject("tips", "姓名只能是zs");
        mv.setViewName("nameError");
        return mv;
    }

    //处理AgeException
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView  doAgeException(Exception e){
        ModelAndView mv  = new ModelAndView();
        mv.addObject("tips", "年龄不能大于80");
        mv.setViewName("ageError");
        return mv;
    }

    //处理其他异常
    @ExceptionHandler
    public ModelAndView  doOtherException(Exception e){
        ModelAndView mv  = new ModelAndView();
        mv.addObject("tips", "请稍后重试");
        mv.setViewName("defaultError");
        return mv;
    }
}
