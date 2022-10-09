package com.teclas.disney.model;

import com.teclas.disney.exception.ResourceNotFoundException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@Getter
@Setter
@Entity
@Table(name = "movie")

public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;
    private String title;
    @Column(name = "release_date")
    private String releaseDate;
    @Column(name = "rating")
    private int rating;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @JoinTable(name = "movie_actors",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @ManyToMany(fetch = LAZY)
    private List<Actor> actors = new ArrayList<>();



    public Movie(Movie movie) {
        setMovieId(movie.getMovieId());
        setTitle(movie.getTitle());
        setReleaseDate(movie.getReleaseDate());
        setRating(movie.getRating());
    }
}
