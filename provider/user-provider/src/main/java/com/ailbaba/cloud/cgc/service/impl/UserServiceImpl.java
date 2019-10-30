package com.ailbaba.cloud.cgc.service.impl;


import com.ailbaba.cloud.cgc.domain.ZUser;
import com.ailbaba.cloud.cgc.mapping.ZUserMapper;
import com.ailbaba.cloud.cgc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "${provider.server.version}")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    ZUserMapper userMapper;

    @Override
    public ZUser getUserById() {
        ZUser zUser = userMapper.selectAll().get(0);
        log.info("测试： user{}",zUser);
        return userMapper.selectAll().get(0);
    }

    @Override
    public int insetUser(String userName, String passWord) {
        log.info("userName: {} , passWord {}",userName,passWord);
        ZUser user = new ZUser();
        user.setUserName(userName);
        user.setPassword(passWord);
        int result = userMapper.insert(user);
        return result;
    }
}
