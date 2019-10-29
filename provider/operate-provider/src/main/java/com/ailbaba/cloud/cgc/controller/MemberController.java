package com.ailbaba.cloud.cgc.controller;

import com.ailbaba.cloud.cgc.domain.ZMember;
import com.ailbaba.cloud.cgc.service.MemberService;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Reference(version = "1.0.0",check = false)
    private MemberService memberService;

    @GetMapping("/operate/info")
    public ZMember info(){
        return memberService.getVIPInfoById();
    }

    @GetMapping("/operate/VIP")
    public int testTransactional(){
        return memberService.insetVIP();
    }
}
