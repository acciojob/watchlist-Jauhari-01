package com.driver;

public class ExceptionMovieExistInRecord extends RuntimeException{
    public ExceptionMovieExistInRecord(String mName,String dName){
        super("Data Already Exists "+mName+" "+dName);
    }
}
