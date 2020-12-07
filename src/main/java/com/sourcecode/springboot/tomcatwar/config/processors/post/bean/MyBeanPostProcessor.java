package com.sourcecode.springboot.tomcatwar.config.processors.post.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

/**
 * @Configuration: 可直接使用@Configuration注解,作为一个配置类被BeanFactory管理
 * @Import: 也可以在启动类上使用@Import注解引入该类,在加载BeanDefinition时会将该类作为一个配置类进行BeanDefinition的加载
 * @ImportBeanDefinitionRegistrar 或者使用@ImportBeanDefinitionRegistrar注解进行导入满足指定规则的BeanDefinition
 */
public class MyBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
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
