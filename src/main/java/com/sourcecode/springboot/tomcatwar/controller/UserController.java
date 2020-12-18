package com.sourcecode.springboot.tomcatwar.controller;

import com.sourcecode.springboot.tomcatwar.config.annotation.MyAdvice;
import com.sourcecode.springboot.tomcatwar.po.UserPO;
import com.sourcecode.springboot.tomcatwar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@MyAdvice
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

    @RequestMapping(
            value = "/query",
            params = {"name=wangwei", "age!=18"},
            headers = {"content-type=*/*"},
            consumes = {},
            produces = {}
            )
    public List<UserPO> queryUser() {
        if (true) {
//            throw new MyException("11111111");
        }
        return userService.queryUser();
    }
}
