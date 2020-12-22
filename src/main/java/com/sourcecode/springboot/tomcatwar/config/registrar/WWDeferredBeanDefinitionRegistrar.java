package com.sourcecode.springboot.tomcatwar.config.registrar;

import com.sourcecode.springboot.tomcatwar.config.annotation.WWEnableAutoConfiguration;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class WWDeferredBeanDefinitionRegistrar implements DeferredImportSelector, BeanClassLoaderAware, ResourceLoaderAware {

    private ClassLoader beanClassLoader;
    private ResourceLoader resourceLoader;

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> factoryNames = SpringFactoriesLoader.loadFactoryNames(WWEnableAutoConfiguration.class, beanClassLoader);
        factoryNames = new ArrayList<>(new LinkedHashSet<>(factoryNames));
        return StringUtils.toStringArray(factoryNames);
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
