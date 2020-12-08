package com.sourcecode.springboot.tomcatwar.service.impl;

import com.sourcecode.springboot.tomcatwar.dao.IUserDao;
import com.sourcecode.springboot.tomcatwar.po.UserPO;
import com.sourcecode.springboot.tomcatwar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int saveUser(UserPO po) {
        return userDao.saveUser(po);
    }

    @Override
    public List<UserPO> queryUser() {
        return userDao.queryUser();
    }
}
