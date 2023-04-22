package com.driver;

public class ExceptionGetDirectorByName extends RuntimeException{
    public ExceptionGetDirectorByName(String name){
        super("Director not listed "+name);
    }
}
