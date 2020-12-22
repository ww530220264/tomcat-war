package com.sourcecode.springboot.tomcatwar;

import com.sourcecode.springboot.tomcatwar.config.annotation.WWScan;
import com.sourcecode.springboot.tomcatwar.config.processors.post.bean.WWBeanPostProcessor;
import com.sourcecode.springboot.tomcatwar.dao.IUserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@WWScan(classes = {WWBeanPostProcessor.class})
@MapperScan(basePackageClasses = {IUserDao.class})
public class TomcatWarApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomcatWarApplication.class, args);
    }

}
