package com.example.service;

import com.example.pojo.Pet;
/**
 *@author 昊洋
 *@date:2021-02-07 11:09
 *@PackageName: com.example.service
 *@description: 
 *@Version 1.0
*/
public interface PetService{


  /**
   * 我都
   * @Date  2021/4/2 12:18
   * @Param
   * @param id11
   * @return com.example.pojo.Pet
   */

    Pet selectByPrimaryKey(Integer id);



}
