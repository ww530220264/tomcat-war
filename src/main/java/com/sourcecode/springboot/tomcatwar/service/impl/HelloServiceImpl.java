package com.sourcecode.springboot.tomcatwar.service.impl;

import com.sourcecode.springboot.tomcatwar.service.IHelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements IHelloService {


    @Override
    public String testAop() {
        return "HELLO-SERVICE";
    }

    @Override
    public String testNoAop() {
        return "NO-AOP";
    }
}
