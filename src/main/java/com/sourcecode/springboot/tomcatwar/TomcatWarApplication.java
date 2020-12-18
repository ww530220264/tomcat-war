package com.sourcecode.springboot.tomcatwar;

import com.sourcecode.springboot.tomcatwar.config.annotation.MyScan;
import com.sourcecode.springboot.tomcatwar.config.processors.post.bean.MyBeanPostProcessor;
import com.sourcecode.springboot.tomcatwar.dao.IUserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MyScan(classes = {MyBeanPostProcessor.class})
@MapperScan(basePackageClasses = {IUserDao.class})
public class TomcatWarApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomcatWarApplication.class, args);
    }

}
