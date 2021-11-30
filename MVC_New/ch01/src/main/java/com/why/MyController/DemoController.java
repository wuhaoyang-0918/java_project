package com.why.MyController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.why.pojo.DateVo;
import com.why.pojo.User;
import com.why.utils.JsonUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author why
 * @date 2021/8/23 14:56
 * @PackageName com.why.MyController
 * @description
 */
@RestController
public class DemoController {
    @RequestMapping("/use")
    public String get() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        User user = new User("吴浩洋",20,new Date());
        return  objectMapper.writeValueAsString(user);
    }
    @RequestMapping("/use1")
    public String get1() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date);
        //return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }
    @PostMapping("/param.do")
    public DateVo dateVo(DateVo dateVo){
      /*  System.out.println("date1:-->"+dateVo.getDate());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dateVo.getDate());
        System.out.println("date2:-->"+date);
*/
        DateVo vo2 = new DateVo();
        vo2.setDate(dateVo.getDate());
        return vo2;
    }
    @PostMapping("/forWard")
    public String forWard(){

        return "forward:/use1";
    }
}
