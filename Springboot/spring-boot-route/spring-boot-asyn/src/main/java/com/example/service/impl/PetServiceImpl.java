package com.example.service.impl;

import com.example.dao.PetMapper;
import com.example.pojo.Pet;
import com.example.service.PetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 *@author 昊洋
 *@date:2021-02-07 11:09
 *@PackageName: com.example.service.impl
 *@description: 
 *@Version 1.0
*/
@Service
public class PetServiceImpl implements PetService{

    @Resource
    private PetMapper petMapper;



    @Override
    public Pet selectByPrimaryKey(Integer id) {
        return petMapper.selectByPrimaryKey(id);
    }


}
