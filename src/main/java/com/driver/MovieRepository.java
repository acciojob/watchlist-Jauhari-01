package com.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class MovieRepository{
    Map<String,Movie> movies;
    Map<String,Director> directors;
    Map<String,List<String>> data;

    public MovieRepository(){
        this.movies = new HashMap<>();
        this.directors = new HashMap<>();
        this.data = new HashMap<>();
    }

    public Optional<Boolean> addMovie(Movie movie){
        if(movies.containsKey(movie.getName())){
            return Optional.empty();
        }
        movies.put(movie.getName(),movie);
        return Optional.of(true);
    }
    public Optional<Boolean> addDirector(Director director){
        if(directors.containsKey(director.getName())){
            return Optional.empty();
        }
        directors.put(director.getName(),director);
        return Optional.of(true);
    }

    public Optional<Boolean> addMovieDirectorPair(String movieName,String directorName){
        
        if(data.get(directorName).contains(movieName)){
            return Optional.empty();
        }
        if(data.get(directorName).size()==0){
            List<String> temp = new ArrayList<>();
            data.put(directorName,temp);
        }
        data.get(directorName).add(movieName);
        return Optional.of(true);
    }
    public Optional<Movie> getMovieByName(String name) {
        if(movies.containsKey(name)){
            return Optional.of(movies.get(name));
        }else{
            return Optional.empty();
        }
    }
    public Optional<Director> getDirectorByName(String name) {
        if(directors.containsKey(name)){
            return Optional.of(directors.get(name));
        }else{
            return Optional.empty();
        }
    }

    public Optional<List<String>> getMoviesByDirectorName(String directorName){
        if(data.containsKey(directorName)){
            return Optional.of(data.get(directorName));
        }else{
            return Optional.empty();
        }
    }
    public Optional<List<Movie>> findAllMovies() {
        if(movies.isEmpty()){
            return Optional.empty();
        }else{
            return Optional.of( new ArrayList<>(movies.values()));
        }
    }
    public Optional<Boolean> deleteDirectorByName(String dName) {
        if(!directors.containsKey(dName)){
            return Optional.empty();
        }else{
            List<String> movieList = data.get(dName);
            for(int i=0 ; i<movieList.size() ; i++){
                String movieName = movieList.get(i);
                if(movies.containsKey(movieName)){
                    movies.remove(movieName);
                }
            }
            if(directors.containsKey(dName)){
                directors.remove(dName);
            }
            data.remove(dName);
            return Optional.of(true);
        }
    }
    public Optional<Boolean> deleteAllDirectors() {
        if(data.isEmpty()){
            return Optional.empty();
        }

        for(String dir : data.keySet()){
            List<String> movieList = data.get(dir);
            for(int i=0 ; i<movieList.size() ; i++){
                String movieName = movieList.get(i);
                if(movies.containsKey(movieName)){
                    movies.remove(movieName);
                }
            }
            if(directors.containsKey(dir)){
                directors.remove(dir);
            }
            data.remove(dir);
        }
        return Optional.of(true);
    }
}