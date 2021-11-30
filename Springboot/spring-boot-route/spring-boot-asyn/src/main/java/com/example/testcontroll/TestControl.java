package com.example.testcontroll;

import com.example.dao.PetMapper;
import com.example.pojo.Pet;
import com.example.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author 昊洋
 */
@RestController
public class TestControl {
    @Resource
    private PetService petService;
    @Autowired
    private PetMapper petMapper;




    @RequestMapping("/user")
     public Pet sho() {
        return petMapper.selectByPrimaryKey(2);

    }
    @RequestMapping("/user1")
    public String sho1() {
        return "777777";
    }

}
