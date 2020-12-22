package com.sourcecode.springboot.tomcatwar.config.annotation;

import com.sourcecode.springboot.tomcatwar.config.registrar.WWDeferredBeanDefinitionRegistrar;
import com.sourcecode.springboot.tomcatwar.config.registrar.WWBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({WWBeanDefinitionRegistrar.class, WWDeferredBeanDefinitionRegistrar.class})
public @interface WWScan {

    @AliasFor("value")
    String[] basePackages() default {};

    @AliasFor("basePackages")
    String[] value() default {};

    Class<?>[] classes() default {};

}
