package com.teclas.disney.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="character_id")
    private Long id;
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
    @ManyToMany(mappedBy = "actors" , fetch = LAZY, cascade=PERSIST)
    private List<Movie> movies = new ArrayList<>();

}
