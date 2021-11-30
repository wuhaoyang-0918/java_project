package com.example.dao;

import com.example.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 昊洋
 * @date:2021-02-07 11:09
 * @PackageName: com.example.dao
 * @description:
 * @Version 1.0
 */
@Mapper
public interface PetMapper {

   /**
    * 查找
    *
    * @return com.example.pojo.Pet
    * @Date 2021/2/7 11:15
    * @Param * @param id
    */

   Pet selectByPrimaryKey(@Param("id") Integer id);


}