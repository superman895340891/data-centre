package com.ailbaba.cloud.cgc.controller;

import com.ailbaba.cloud.cgc.domain.ZMember;
import com.ailbaba.cloud.cgc.service.MemberService;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberController {

    @Reference(version = "${provider.server.version}")
    private MemberService memberService;

    @GetMapping("/operate/info")
    public ZMember info() {
        return memberService.getVIPInfoById();
    }

//    @GetMapping("/operate/VIP")
//    public int testTransactional() {
//        return memberService.insetVIP();
//    }

    @GetMapping("/method")
    public String testMethod() {
        log.info("是否注入: {}",memberService);
        return memberService.testMethod();
    }
}
