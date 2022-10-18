package com.novare.natflixbackend.controllers;


import com.novare.natflixbackend.models.Content;
import com.novare.natflixbackend.models.Film;
import com.novare.natflixbackend.repositories.FilmRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details_films")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;

    @GetMapping
    public List<Film> list() { return filmRepository.findAll(); }

    @GetMapping
    @RequestMapping("{id}")
    public Film get(@PathVariable Integer id) {
        return filmRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Film create( @RequestBody final Film film) {
        return filmRepository.saveAndFlush(film);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Film update(@PathVariable Integer id, @RequestBody Film film) {
        // TODO: Add validation that all attributes are passed in, otherwise return 400 bad payload.
        Film existingFilm = filmRepository.getReferenceById(id);
        BeanUtils.copyProperties(film, existingFilm, "id");
        return filmRepository.saveAndFlush(existingFilm);
    }
}
