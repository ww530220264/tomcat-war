package com.sourcecode.springboot.tomcatwar.dao;

import com.sourcecode.springboot.tomcatwar.po.UserPO;

import java.util.List;

public interface IUserDao {
    int saveUser(UserPO po);
    List<UserPO> queryUser();
}
