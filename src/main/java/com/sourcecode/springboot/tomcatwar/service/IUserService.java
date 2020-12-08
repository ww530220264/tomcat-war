package com.sourcecode.springboot.tomcatwar.service;

import com.sourcecode.springboot.tomcatwar.po.UserPO;

import java.util.List;

public interface IUserService {
    int saveUser(UserPO po);
    List<UserPO> queryUser();
}
