package com.sourcecode.springboot.tomcatwar.config.mvc.advice;

import com.sourcecode.springboot.tomcatwar.config.annotation.WWAdvice;
import com.sourcecode.springboot.tomcatwar.config.exception.WWException;
import com.sourcecode.springboot.tomcatwar.vo.HttpResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@ControllerAdvice(annotations = {WWAdvice.class})
public class WWControllerAdvice implements ResponseBodyAdvice<Object>, RequestBodyAdvice {


    @ExceptionHandler({WWException.class})
    public HttpResult handleMyException(WWException e){
        e.printStackTrace();
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(-1);
        httpResult.setMsg(e.getMessage());
        return httpResult;
    }


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.err.println("my responseBodyAdvice: supports: " + returnType);
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        System.err.println("my responseBodyAdvice: beforeBodyWrite: " + body);
        return body;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.err.println("my requestBodyAdvice: supports: " + true);
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        System.err.println("my requestBodyAdvice: beforeBodyRead: " + parameter);
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.err.println("my requestBodyAdvice: afterBodyRead: " + body);
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.err.println("my requestBodyAdvice: handleEmptyBody: " + body);
        return body;
    }
}
