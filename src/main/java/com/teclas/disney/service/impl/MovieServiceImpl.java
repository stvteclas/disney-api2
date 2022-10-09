package com.teclas.disney.service.impl;

import com.teclas.disney.exception.ResourceNotFoundException;

import com.teclas.disney.model.Movie;

import com.teclas.disney.repository.MovieRepository;

import com.teclas.disney.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {


        private MovieRepository movieRepository;

        public MovieServiceImpl(MovieRepository movieRepository) {
            super();
            this.movieRepository = movieRepository;
        }

        @Override
        public Movie saveMovie(Movie movie) {
            return movieRepository.save(movie);
        }

        @Override
        public List<Movie> getAllMovies() {
            return movieRepository.findAll();
        }


        @Override
        public Movie getMovieById(long id) {

            return movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie", "Id", id));
        }

        @Override
        public Movie updateMovie(Movie movie, long id) {
            Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor", "Id", id));
           existingMovie.setTitle(movie.getTitle());
           existingMovie.setReleaseDate(movie.getReleaseDate());
           existingMovie.setRating(movie.getRating());
           existingMovie.setActors(movie.getActors()
                    );
            return existingMovie;
        }

        @Override
        public void deleteMovie(long id) {
            //check whether an actor exist in DB or not
            movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie", "Id", id));
            movieRepository.deleteById(id);

        }

}
