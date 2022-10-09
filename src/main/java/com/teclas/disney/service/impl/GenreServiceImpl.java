package com.teclas.disney.service.impl;

import com.teclas.disney.model.Genre;
import com.teclas.disney.repository.GenreRepository;
import com.teclas.disney.service.GenreService;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private GenreRepository genreRepository;

    @Override
    public Genre createGenre(Genre genre){
        return genreRepository.save(genre);
    }
}
