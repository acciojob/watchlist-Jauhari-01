package com.driver;

public class ExceptionGetMovieByName extends RuntimeException{
    public ExceptionGetMovieByName(String name){
        super("Movie not found in DB "+name);
    }
}
