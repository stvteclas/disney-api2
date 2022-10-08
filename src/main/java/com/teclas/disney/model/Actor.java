package com.teclas.disney.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "image", nullable = false)
    private String image;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String age;
    @Column(name = "weight")
    private String weight;
    @Column(name = "history")
    private String history;
    @Column(name = "associated_movies")
    private String associatedMovies;

}
