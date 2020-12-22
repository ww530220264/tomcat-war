package com.sourcecode.springboot.tomcatwar.config.processors.post.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

public class WWBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        if (isMyClass(bean)) {
            System.err.println("获取早的bean引用...: " + beanName + ": " + bean.getClass().getName());
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isMyClass(beanClass)) {
            System.err.println("实例化前调用...: " + beanName);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (isMyClass(bean)) {
            System.err.println("实例化后调用...: " + beanName);
        }
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (isMyClass(bean)) {
            System.err.println("初始化前调用...: " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (isMyClass(bean)) {
            System.err.println("初始化后调用...: " + beanName);
        }
        return bean;
    }

    public boolean isMyClass(Object bean) {
        if (bean instanceof Class<?>) {
            return ((Class<?>) bean).getName().startsWith("com.sourcecode.springboot");
        }
        if (bean instanceof Object) {
            return bean.getClass().getName().startsWith("com.sourcecode.springboot");
        }
        return false;
    }
}
