package com.sourcecode.springboot.tomcatwar;

import com.sourcecode.springboot.tomcatwar.annotation.MyScan;
import com.sourcecode.springboot.tomcatwar.config.processors.post.bean.MyBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyScan(classes = {MyBeanPostProcessor.class})
public class TomcatWarApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomcatWarApplication.class, args);
    }

}
