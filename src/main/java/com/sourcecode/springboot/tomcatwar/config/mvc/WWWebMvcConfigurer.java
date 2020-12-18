package com.sourcecode.springboot.tomcatwar.config.mvc;

import com.sourcecode.springboot.tomcatwar.config.mvc.interceptor.MyWebInterceptor_1;
import com.sourcecode.springboot.tomcatwar.config.mvc.interceptor.MyWebInterceptor_2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WWWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyWebInterceptor_1()).addPathPatterns("/**");
        registry.addInterceptor(new MyWebInterceptor_2()).addPathPatterns("/**");
    }
}
