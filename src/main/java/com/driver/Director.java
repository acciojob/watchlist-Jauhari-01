package com.driver;

public class Director{
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director(){
    }

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

    public void setName(String name){
        this.name = name;
    }
    public void setNumberOfMovies(int val){
        this.numberOfMovies = val;
    }
    public void setImdbRating(double val){
        this.imdbRating = val;
    }
    public void setDirector(String name,int numberOfMovies,double rating){
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = rating;
    }
}