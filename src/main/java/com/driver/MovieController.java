package com.driver;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController{
    MovieService service = new MovieService();

    //1
    @PostMapping("POST/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        try{
            service.addMovie(movie);    
            return new ResponseEntity("Movie added successfully",HttpStatus.OK);
        }catch(ExceptionMovieAlreadyExist e){
            return new ResponseEntity("Movie added successfully",HttpStatus.BAD_REQUEST);
        }        
    }

    //2
    @PostMapping("POST/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        try{
            service.addDirector(director);
            return new ResponseEntity("Director added successfully",HttpStatus.OK);
        }catch(ExceptionDirectorAlreadyExist e){
            return new ResponseEntity("Movie added successfully",HttpStatus.BAD_REQUEST);
        }
    }

    //3
    @PutMapping("PUT/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        try{
            service.addMovieDirectorPair(movie,director);
            return new ResponseEntity("Director added successfully",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity("Movie added successfully",HttpStatus.BAD_REQUEST);
        }
    }

    //4
    @GetMapping("GET/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        try{
            Movie movie = service.getMovieByName(name);
            return new ResponseEntity(movie,HttpStatus.OK);
        }catch (ExceptionGetMovieByName e){
            return new ResponseEntity("Movie added successfully",HttpStatus.BAD_REQUEST);
        }
    }

    //5
    @GetMapping("GET/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        try{
            Director director = service.getDirectorByName(name);
            return new ResponseEntity(director,HttpStatus.OK);
        }catch (ExceptionGetDirectorByName e){
            return new ResponseEntity("Director not found",HttpStatus.BAD_REQUEST);
        }
    }


    //6
    @GetMapping("GET/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        try{
            List<String> listmovies = service.getMoviesByDirectorName(director);
            return new ResponseEntity(listmovies, HttpStatus.OK);
        }catch(ExceptionGetDirectorByName e){
            return new ResponseEntity("Director not found",HttpStatus.valueOf(404));
        }
    }


    //7
    @GetMapping("GET/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        try{
            List<Movie> list = service.findAllMovies();
            return new ResponseEntity(list, HttpStatus.OK);
        }catch(ExceptionMovieEmpty e){
            return new ResponseEntity("there is no movies present in database",HttpStatus.BAD_REQUEST);
        }
    }

    //8
    @DeleteMapping("DELETE/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String directorName){
        try{
            service.deleteDirectorByName(directorName);
            return new ResponseEntity("Successfully done", HttpStatus.OK);
        }catch(ExceptionDirectorEmpty e){
            return new ResponseEntity("there is no Director present in database",HttpStatus.BAD_REQUEST);
        }
    }


    //9
    @DeleteMapping("DELETE/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        try{
            service.deleteAllDirectors();
            return new ResponseEntity("Successfully done", HttpStatus.OK);
        }catch(ExceptionDataEmpty e){
            return new ResponseEntity("there is no Director present in database",HttpStatus.BAD_REQUEST);
        }
    }
}