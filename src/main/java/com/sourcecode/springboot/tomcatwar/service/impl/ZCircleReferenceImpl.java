package com.sourcecode.springboot.tomcatwar.service.impl;

import com.sourcecode.springboot.tomcatwar.service.ICircleReferenceService;
import com.sourcecode.springboot.tomcatwar.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZCircleReferenceImpl implements ICircleReferenceService {

    @Autowired
    private IHelloService helloService;

    @Override
    public String test() {
        return helloService.testNoAop();
    }

    @Override
    public String getServiceName() {
        return "CIRCLE-REFERENCE-SERVICE";
    }
}
