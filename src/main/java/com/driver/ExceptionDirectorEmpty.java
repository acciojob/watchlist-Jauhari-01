package com.driver;

public class ExceptionDirectorEmpty extends RuntimeException{
    public ExceptionDirectorEmpty(String name){
        super("Director not found of "+name);
    }
}
