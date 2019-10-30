package com.ailbaba.cloud.cgc.service;

import com.ailbaba.cloud.cgc.domain.ZMember;

public interface MemberService {

    ZMember getVIPInfoById();

    int insetVIP();

    String testMethod();
}
