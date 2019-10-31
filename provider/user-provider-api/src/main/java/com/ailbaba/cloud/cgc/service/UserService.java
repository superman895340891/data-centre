package com.ailbaba.cloud.cgc.service;

import com.ailbaba.cloud.cgc.domain.ZUser;

public interface UserService {

    ZUser getUserById();

    int insetUser(String userName,String passWord);

}
