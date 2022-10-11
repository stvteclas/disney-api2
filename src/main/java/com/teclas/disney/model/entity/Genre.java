package com.teclas.disney.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name= "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private Long genreId;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Movie.class)
    private List<Movie> movies;

}
