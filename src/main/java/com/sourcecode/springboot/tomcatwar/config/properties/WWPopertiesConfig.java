package com.sourcecode.springboot.tomcatwar.config.properties;

import com.sourcecode.springboot.tomcatwar.properties.WWProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({WWProperties.class})
public class WWPopertiesConfig {
}
