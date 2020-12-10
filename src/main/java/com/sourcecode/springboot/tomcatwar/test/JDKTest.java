package com.sourcecode.springboot.tomcatwar.test;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloService hello = new HelloServiceImpl();
        HelloService proxy = (HelloService) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                hello.getClass().getInterfaces(),
                new HelloInvokeHandler(hello));
        String result = proxy.sayHello("ww");
        System.err.println("===================================================");
        System.err.println("the result of sayHello invoked by proxy: " + result);
    }

    public static class HelloInvokeHandler implements InvocationHandler {
        private Object target;

        public HelloInvokeHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            System.err.println("before invoke method '" + methodName + "'");
            Object result = method.invoke(target, args);
            System.err.println("before invoke method '" + methodName + "'");
            return result;
        }
    }

    public interface HelloService {
        String sayHello(String name);
    }

    public static class HelloServiceImpl implements HelloService {

        @Override
        public String sayHello(String name) {
            System.err.println("i am " + name);
            return "i am " + name;
        }

        public String sayCglib(String name) {
            System.err.println("i am " + name);
            return "i am " + name;
        }
    }
}
