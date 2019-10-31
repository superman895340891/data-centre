package com.ailbaba.cloud.cgc.service.impl;

import com.ailbaba.cloud.cgc.domain.ZMember;
import com.ailbaba.cloud.cgc.domain.ZUser;
import com.ailbaba.cloud.cgc.mapping.ZMemberMapping;
import com.ailbaba.cloud.cgc.service.MemberService;
import com.ailbaba.cloud.cgc.service.UserService;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;


import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service(version = "${provider.server.version}")
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    ZMemberMapping memberMapping;

    @Reference(version = "${provider.server.version}",check = false)
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
    @GlobalTransactional
    public int insetVIP(int id) {
        ZMember member = new ZMember();
        member.setuId(id);
        member.setIsVip(1);
        int insert = memberMapping.insert(member);
        log.info("本地事务： {}" , insert);
        return insert;
    }

    @Override
    public String testMethod() {
        List<ZMember> zMembers = memberMapping.selectAll();
        log.info("测试:  {} ",zMembers );
        return "zMembers.toString()";
    }
}
