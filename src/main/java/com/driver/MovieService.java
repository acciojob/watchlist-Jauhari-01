package com.driver;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService{
    @Autowired
    MovieRepository repo;
    public void addMovie(Movie movie){ 
        Optional<Boolean> opt = repo.addMovie(movie);
        if(opt.isPresent()){
            return;
        }else{
            throw new ExceptionMovieAlreadyExist(movie);
        } 
    }
    public void addDirector(Director director){
        Optional<Boolean> opt = repo.addDirector(director);
        if(opt.isPresent()){
            return;
        }else{
            throw new ExceptionDirectorAlreadyExist(director);
        } 
    }
    public void addMovieDirectorPair(String movie,String director){
        Optional<Boolean> opt = repo.addMovieDirectorPair(movie,director);
        if(opt.isPresent()){
            return;
        }else{
            throw new ExceptionMovieExistInRecord(movie,director);
        } 
    }
    public Movie getMovieByName(String name) {
        Optional<Movie> optionalVar = repo.getMovieByName(name);
        if(optionalVar.isPresent()){
            return optionalVar.get();
        }else{
            throw new ExceptionGetMovieByName(name);
        }
    }
    public Director getDirectorByName(String name) {
        Optional<Director> optionalVar = repo.getDirectorByName(name);
        if(optionalVar.isPresent()){
            return optionalVar.get();
        }else{
            throw new ExceptionGetMovieByName(name);
        }
    }

    public List<String> getMoviesByDirectorName(String directorName){
        Optional<List<String>> optVar = repo.getMoviesByDirectorName(directorName);
        if(optVar.isPresent()){
            return optVar.get();
        }else{
            throw new ExceptionGetDirectorByName(directorName);
        }
    }
    public List<Movie> findAllMovies() {
        Optional<List<Movie>> op = repo.findAllMovies();
        if(op.isPresent()){
            return op.get();
        }else{
            throw new ExceptionMovieEmpty();
        }
    }
    public void deleteDirectorByName(String dName) {
        Optional<Boolean> op = repo.deleteDirectorByName(dName);
        if(op.isPresent()){
            return;
        }else{
            throw new ExceptionDirectorEmpty(dName);
        }
    }
    public void deleteAllDirectors() {
        Optional<Boolean> op = repo.deleteAllDirectors();
        if(op.isPresent()){
            return;
        }else{
            throw new ExceptionDataEmpty();
        }
    }
}