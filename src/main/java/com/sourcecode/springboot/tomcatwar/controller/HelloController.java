package com.sourcecode.springboot.tomcatwar.controller;

import com.sourcecode.springboot.tomcatwar.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @GetMapping("/index")
    public String index() {
        return "OK";
    }

    @GetMapping("/aop")
    public String aop() {
        return helloService.testAop();
    }

    @GetMapping("/noAop")
    public String noAop() {
        return helloService.testNoAop();
    }
}
