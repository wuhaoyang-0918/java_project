package com.example.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author why
 * @date 2021/10/25 16:46
 * @PackageName com.example.User
 * @description
 */
@Data
@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("用户名")
    public String username;
    @ApiModelProperty("密码")
    public String password;}
