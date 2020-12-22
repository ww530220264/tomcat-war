package com.sourcecode.springboot.tomcatwar.config.exception;

public class WWException extends RuntimeException{

    public WWException(){
        super();
    }

    public WWException(String message){
        super(message);
    }
}
