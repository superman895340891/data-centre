package com.ailbaba.cloud.cgc.service.impl;

import com.ailbaba.cloud.cgc.domain.ZMember;
import com.ailbaba.cloud.cgc.domain.ZUser;
import com.ailbaba.cloud.cgc.mapping.ZMemberMapping;
import com.ailbaba.cloud.cgc.service.MemberService;
import com.ailbaba.cloud.cgc.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;


@Service(version = "1.0.0")
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    ZMemberMapping memberMapping;

    @Reference(version = "1.0.0",loadbalance = "txlcn_random")
    private UserService userService;

    @Override
    public ZMember getVIPInfoById() {
        ZUser userById = userService.getUserById();
        log.info(" user{}",userById);
        ZMember zMember = new ZMember();
        zMember.setuId(userById.getId());
        ZMember memberResult = memberMapping.selectOne(zMember);
        log.info(" memberResult{} ",memberResult);
        return memberResult;
    }

    @Override
    public int insetVIP() {
        int userId = userService.insetUser("张三", "123456");
        ZMember member = new ZMember();
        member.setuId(userId);
        member.setIsVip(1);
        int insert = memberMapping.insert(member);
        return insert;
    }
}
