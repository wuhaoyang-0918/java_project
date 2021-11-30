package com.demo.controll;

import com.demo.pojo.Books;
import com.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 昊洋
 * @date:2021-08-02 9:48
 * @PackageName: com.demo.controll
 * @description:
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/book")
public class UserController {
    @Autowired
    private BookService bookService;
    //查询全部书籍，并且返回到一个页面进行显示
    @RequestMapping("/allBooks")
    public String list(Model model) {
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list", books);
        return "allBooks";
    }
    @GetMapping("/getJson")
    @ResponseBody
    public List<Books> getList() {
        return bookService.queryAllBooks();
    }
    /**
     * 获取Cookie
     */
    @RequestMapping("/testCookie")
    @ResponseBody
    public String handleCookieValue(@CookieValue(value="JSESSIONID") String cookie)
    {
        System.out.println("Request CookieValue JSESSIONID:"+cookie);
        return "SESSION";
    }
    /**
     * 测试JReb
     */
    @RequestMapping("/test")
    @ResponseBody
    public String handle()
    {
        return "1";
    }


}
