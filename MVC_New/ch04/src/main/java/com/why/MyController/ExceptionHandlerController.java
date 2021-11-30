package com.why.MyController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author why
 * @date 2021/8/25 19:47
 * @PackageName com.why.MyController
 * @description
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})

    public String handleArithmeticException(Exception ex, Model model){
        model.addAttribute("ex", ex);
        return "error";
    }
}
