package com.sourcecode.springboot.tomcatwar.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Aspect
@Component
public class WWAspect {

    @Pointcut("execution(* *.testAop(..))")
    public void testAop() {
    }

    @Before("testAop()")
    public void before() {
        System.err.println("before...");
    }

    @After("testAop()")
    public void after() {
        System.err.println("after...");
    }

    @AfterReturning("testAop()")
    public void afterReturning() {
        System.err.println("afterReturning...");
    }

    @AfterThrowing("testAop()")
    public void afterThrowing() {
        System.err.println("afterThrowing...");
    }

    @Around("testAop()")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.err.println("around before...");
        Object[] args = joinPoint.getArgs();
        System.out.println("参数是: " + StringUtils.arrayToCommaDelimitedString(args));
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.err.println("around after...");
        return result;
    }
}
