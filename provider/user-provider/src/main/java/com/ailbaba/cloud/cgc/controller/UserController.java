package com.ailbaba.cloud.cgc.controller;


import com.ailbaba.cloud.cgc.domain.ZUser;
import com.ailbaba.cloud.cgc.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Reference(version = "${provider.server.version}",check = false)
    private UserService userService;

    @GetMapping("/user/id")
    public ZUser selectUserById(){
        return userService.getUserById();
    }

    @PostMapping("/user")
    public int addUser(@RequestBody ZUser user){
        return userService.insetUser(user.getUserName(),user.getPassword());
    }

}
