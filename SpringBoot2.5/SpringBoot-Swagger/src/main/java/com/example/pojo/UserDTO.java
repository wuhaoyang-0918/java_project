package com.example.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author why
 * @date 2021/10/25 15:12
 * @PackageName com.example.pojo
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户", description = "查询用户")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 78806598597025327L;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String username;

}
