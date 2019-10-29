package com.ailbaba.cloud.cgc.controller;


import com.ailbaba.cloud.cgc.domain.ZUser;
import com.ailbaba.cloud.cgc.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Reference(version = "1.0.0",check = false)
    private UserService userService;

    @GetMapping("/user/id")
    public ZUser selectUserById(){
        return userService.getUserById();
    }
}
