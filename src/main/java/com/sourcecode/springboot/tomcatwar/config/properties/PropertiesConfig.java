package com.sourcecode.springboot.tomcatwar.config.properties;

import com.sourcecode.springboot.tomcatwar.properties.MyProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({MyProperties.class})
public class PropertiesConfig {
}
