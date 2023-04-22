package com.driver;

public class ExceptionMovieEmpty extends RuntimeException{
    public ExceptionMovieEmpty(){
        super("Not Found");
    }
}
