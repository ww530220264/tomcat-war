package com.sourcecode.springboot.tomcatwar.test;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"C:\\wangwei\\tomcat-war\\build\\classes\\java\\main");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(JDKTest.HelloServiceImpl.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            System.err.println("before invoke method: " + method.getName());
            Object result = proxy.invokeSuper(obj, args1);
            System.err.println("after invoke method: " + method.getName());
            return result;
        });
        JDKTest.HelloServiceImpl helloServiceImpl = (JDKTest.HelloServiceImpl) enhancer.create();
        helloServiceImpl.sayCglib("cglib");
        helloServiceImpl.sayCglibFinal("cglib_final"); // final不会被继承
        System.err.println(helloServiceImpl);
    }
}
