package com.sourcecode.springboot.tomcatwar.controller;

import com.sourcecode.springboot.tomcatwar.po.UserPO;
import com.sourcecode.springboot.tomcatwar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/save")
    public int saveUser(String name) {
        UserPO userPO = new UserPO();
        userPO.setName(name);
        return userService.saveUser(userPO);
    }
    @RequestMapping("/saveWithTX")
    public int saveWithTX(String name) {
        UserPO userPO = new UserPO();
        userPO.setName(name);
        return userService.saveUser(userPO);
    }

    @RequestMapping("/query")
    public List<UserPO> queryUser() {
        return userService.queryUser();
    }
}
