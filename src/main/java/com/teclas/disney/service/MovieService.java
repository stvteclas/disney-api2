package com.teclas.disney.service;

import com.teclas.disney.model.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie saveMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie getMovieById(long id);
    Movie updateMovie(Movie movie, long id);
    void deleteMovie(long id);
}
