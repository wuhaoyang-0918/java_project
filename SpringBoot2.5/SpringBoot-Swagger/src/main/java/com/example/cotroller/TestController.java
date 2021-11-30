package com.example.cotroller;

import com.example.pojo.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author why
 * @date 2021/10/25 18:46
 * @PackageName com.example.cotroller
 * @description
 */
@RestController
@RequestMapping("/swagger")
@Api(value = "Swagger2在线接口文档")
public class TestController {
    @GetMapping("/get/{id}")
  // @ApiImplicitParam(dataType = "Long",name = "id",value = "Id",required = false)
    @ApiOperation(value = "根据用户唯一标识获取用户信息")
    public UserDTO getUserInfo(@PathVariable @ApiParam(value = "用户唯一标识") Long id) {
        // 模拟数据库中根据id获取User信息
       return new UserDTO(1,"zs");
    }
    @PostMapping("/insert")
    @ApiOperation(value = "添加用户信息")
    public UserDTO insertUser(@RequestBody @ApiParam(value = "用户信息") UserDTO user) {
        // 处理添加逻辑
        return new UserDTO(2,"ls");
    }
}
