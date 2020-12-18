package com.sourcecode.springboot.tomcatwar.config.registrar;

import com.sourcecode.springboot.tomcatwar.config.annotation.MyScan;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MyRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(MyScan.class.getName()));
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        List<String> backPackages = new ArrayList<>();
        for (Class<?> clazz : annAttrs.getClassArray("classes")) {
            backPackages.add(ClassUtils.getPackageName(clazz));
        }
        if (null != resourceLoader) {
            scanner.setResourceLoader(resourceLoader);
        }
        // 添加includeFilter
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> metadataReader.getClassMetadata().getClassName().startsWith("com.sourcecode.springboot"));
        scanner.scan(StringUtils.toStringArray(backPackages));
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
