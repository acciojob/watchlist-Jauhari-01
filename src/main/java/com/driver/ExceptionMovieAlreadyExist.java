package com.driver;

public class ExceptionMovieAlreadyExist extends RuntimeException{
    public ExceptionMovieAlreadyExist(Movie movie){
        super("Movie already exists "+movie);
    }
}
