package com.sourcecode.springboot.tomcatwar.service.impl;

import com.sourcecode.springboot.tomcatwar.service.ICircleReferenceService;
import com.sourcecode.springboot.tomcatwar.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements IHelloService {

    @Autowired
    private ICircleReferenceService circleReferenceService;

    @Override
    public String testAop() {
        return "HELLO-SERVICE";
    }

    @Override
    public String testNoAop() {
        return "NO-AOP";
    }

    @Override
    public String getCircleServiceName() {
        return circleReferenceService.getServiceName();
    }
}
