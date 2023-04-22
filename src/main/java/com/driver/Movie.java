package com.driver;

public class Movie{
    private String name;
    private int durationInMinutes;
    private double imdbRating;
    public Movie(String name,int duration,double rating){
        this.name = name;
        this.durationInMinutes = duration;
        this.imdbRating = rating;
    }

    public String getName(){
        return this.name;
    }
    public int getDurationInMinutes(){
        return this.durationInMinutes;
    }
    public double getImdbRating(){
        return this.imdbRating;
    }
    public Movie getMovie(){
        return this;
    }
}