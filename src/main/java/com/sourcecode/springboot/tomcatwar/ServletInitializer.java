package com.sourcecode.springboot.tomcatwar;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TomcatWarApplication.class); // 在SpringApplication中添加该source,bean定义加载器加载的时候会加载该source
    }

}
