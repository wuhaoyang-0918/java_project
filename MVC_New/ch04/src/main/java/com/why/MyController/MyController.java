package com.why.MyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author why
 * @date 2021/8/25 19:32
 * @PackageName com.why.MyController
 * @description
 */
@Controller
public class MyController {
    @ResponseBody
    @RequestMapping("/Ex")
public String testExceptionHandler(){
    System.out.println(1/0);
    return "success";
}

}
