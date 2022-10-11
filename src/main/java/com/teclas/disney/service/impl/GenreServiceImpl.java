package com.teclas.disney.service.impl;

import com.teclas.disney.model.entity.Genre;
import com.teclas.disney.repository.GenreRepository;
import com.teclas.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
@Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre createGenre(Genre genre){
        return genreRepository.save(genre);
    }

    @Override
    public Genre insertGenre(Genre obj) {
        return genreRepository.save(obj);
    }

    @Override
    public List<Genre> listGenre() {
        return genreRepository.findAll();
    }
}
