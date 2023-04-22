package com.driver;
public class Director{
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director(String name,int numberOfMovies,double rating){
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = rating;
    }

    public String getName(){
        return this.name;
    }
    public int getNumberOfMovies(){
        return this.numberOfMovies;
    }
    public double getImdbRating(){
        return this.imdbRating;
    }
    public Director getDirector(){
        return this;
    }
}