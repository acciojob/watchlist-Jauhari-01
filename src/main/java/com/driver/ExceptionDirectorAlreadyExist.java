package com.driver;

public class ExceptionDirectorAlreadyExist extends RuntimeException {
    public ExceptionDirectorAlreadyExist(Director dirctor){
        super("Already Exist "+dirctor );
    }
}
