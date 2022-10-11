package com.teclas.disney.model.entity;

import com.teclas.disney.model.entity.Actor;
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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;


   @JoinTable(name = "movie_actors",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @ManyToMany(fetch = LAZY)
    private List<Actor> actors = new ArrayList<>();

}
