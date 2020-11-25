package com.sourcecode.springboot.tomcatwar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloTomcat {

    @GetMapping("/index")
    public String index(){
        return "OK";
    }
}
