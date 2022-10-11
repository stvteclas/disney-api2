package com.teclas.disney.controller;

import com.teclas.disney.model.entity.Genre;
import com.teclas.disney.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private GenreService genreService;
    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre){
        return new ResponseEntity<Genre>(genreService.createGenre(genre), HttpStatus.CREATED);
    }
}
