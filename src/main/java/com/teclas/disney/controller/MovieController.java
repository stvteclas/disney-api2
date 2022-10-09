package com.teclas.disney.controller;

import com.teclas.disney.model.Actor;
import com.teclas.disney.model.Movie;
import com.teclas.disney.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService){
        super();
        this.movieService = movieService;
    }

    //build create movie REST API
    @PostMapping("/movie/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }
    // build get all Movies REST API
    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    //build get movie by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") long movieid){
        return new ResponseEntity<Movie>(movieService.getMovieById(movieid), HttpStatus.OK);
    }

    //build update actor REST API
    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") long id , @RequestBody Movie movie){
        return new ResponseEntity<Movie>( movieService.updateMovie(movie, id) , HttpStatus.OK);
    }

    //build delete Movie REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable ("id") long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<String>("Movie delete successfully", HttpStatus.OK);
    }
}
