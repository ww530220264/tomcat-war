package com.sourcecode.springboot.tomcatwar.test;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class CglibTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\wangwei\\tomcat-war\\build\\classes\\java\\main");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(JDKTest.HelloServiceImpl.class);
        enhancer.setCallbacks(new Callback[]{
                (MethodInterceptor) (obj, method, args1, proxy) -> {
                    System.err.println("inceptor-1---before invoke method: " + method.getName());
                    Object result = proxy.invokeSuper(obj, args1);
                    System.err.println("inceptor-1---after invoke method: " + method.getName());
                    return result;
                },
                (MethodInterceptor) (obj, method, args1, proxy) -> {
                    System.err.println("inceptor-2---before invoke method: " + method.getName());
                    Object result = proxy.invokeSuper(obj, args1);
                    System.err.println("inceptor-2---after invoke method: " + method.getName());
                    return result;
                }
        });
        enhancer.setCallbackFilter(new CallbackFilter() {
            private AtomicInteger counter = new AtomicInteger();
            @Override
            public int accept(Method method) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });
        JDKTest.HelloServiceImpl helloServiceImpl = (JDKTest.HelloServiceImpl) enhancer.create();
        helloServiceImpl.sayCglib("cglib");
//        helloServiceImpl.sayCglibFinal("cglib_final"); // final不会被继承
//        System.err.println(helloServiceImpl);
    }
}
