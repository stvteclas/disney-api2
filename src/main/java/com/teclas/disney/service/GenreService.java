package com.teclas.disney.service;

import com.teclas.disney.model.entity.Genre;

import java.util.List;

public interface GenreService {
    Genre createGenre(Genre genre);
    public Genre insertGenre(Genre obj);
    List<Genre> listGenre();
}
