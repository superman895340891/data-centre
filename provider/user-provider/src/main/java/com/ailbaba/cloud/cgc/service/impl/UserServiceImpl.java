package com.ailbaba.cloud.cgc.service.impl;


import com.ailbaba.cloud.cgc.domain.ZUser;
import com.ailbaba.cloud.cgc.mapping.ZUserMapper;
import com.ailbaba.cloud.cgc.service.MemberService;
import com.ailbaba.cloud.cgc.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@Service(version = "${provider.server.version}")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private ZUserMapper userMapper;

    @Reference(version = "${provider.server.version}",check = false)
    private MemberService memberService;

    @Override
    public ZUser getUserById() {
        ZUser zUser = userMapper.selectAll().get(0);
        log.info("测试： user{}", zUser);
        return userMapper.selectAll().get(0);
    }

    @Override
    @GlobalTransactional
    public int insetUser(String userName, String passWord) {
        if (!"张三".equals(userName)){
            return 20002;
        }
        if (!"123456".equals(passWord)){
            return 20003;
        }
        log.info("userName: {} , passWord {}", userName, passWord);
        ZUser user = new ZUser();
        user.setUserName(userName);
        user.setPassword(passWord);
        userMapper.insert(user);
        int vipResult = memberService.insetVIP(user.getId());
        return vipResult;
    }

}
