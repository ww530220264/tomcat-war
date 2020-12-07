package com.sourcecode.springboot.tomcatwar.annotation;

import com.sourcecode.springboot.tomcatwar.config.registrar.MyHandlerRegistrar;
import com.sourcecode.springboot.tomcatwar.config.registrar.MyRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MyRegistrar.class, MyHandlerRegistrar.class})
public @interface MyScan {

    @AliasFor("value")
    String[] basePackages() default {};

    @AliasFor("basePackages")
    String[] value() default {};

    Class<?>[] classes() default {};

}
