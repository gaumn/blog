package com.invain.controller;


import com.invain.Core.Return.Result;
import com.invain.entity.User;
import com.invain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author invain
 * @since 2022-01-11
 */


@RestController
/**告诉spring容器这个Java类将用于基于Rest的服务，
 * 此注解将自动处理以jason或xml方式传递到服务中的数据的序列化，
 * 在默认情况下，@RestController类将返回的数据序列化为json，
 * 同时这个注解下的方法不需要再返回ResponseBody类
 **/
@RequestMapping("/user")
//这一注解告诉spring容器本方法将要公开的http端点
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/index")
    public Result test() {
        User user= userService.getById(2L);
//        System.out.println(":"+user+"err");
        return Result.err(user);
    }

    @GetMapping("/ind")
    public Result test2() {
        User user= userService.getById(1L);
//        System.out.println(user);
        return Result.success(user);
    }
}