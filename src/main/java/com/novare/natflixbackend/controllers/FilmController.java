package com.novare.natflixbackend.controllers;


import com.novare.natflixbackend.models.Content;
import com.novare.natflixbackend.models.Film;
import com.novare.natflixbackend.repositories.ContentRepository;
import com.novare.natflixbackend.repositories.FilmRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details-films")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ContentRepository contentRepository;

    @GetMapping
    public List<Film> list() { return filmRepository.findAll(); }

    @GetMapping
    @RequestMapping("{contentId}")
    public Film get(@PathVariable Integer contentId) {
        Film film = filmRepository.findByContentId(contentId);

        if (film == null) {
            film = new Film();
            film.setContentId(contentId);
            // Do I need to set the content as well?
            Content content = contentRepository.getReferenceById(contentId);
            film.setContent(content);
            filmRepository.saveAndFlush(film);
        }
        return film;
    }

    @PostMapping(name = "create")
    @ResponseStatus(HttpStatus.CREATED)
    public Film create( @RequestBody final Film film) {
        Integer contentId = film.getContentId();
        Content content = contentRepository.getReferenceById(contentId);
        film.setContent(content);
 //       content.setFilm(film);
        contentRepository.saveAndFlush(content);
        return filmRepository.saveAndFlush(film);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Film update(@RequestBody Film film) {
        // TODO: Add validation that all attributes are passed in, otherwise return 400 bad payload.
        int id = film.getId();
        Film existingFilm = filmRepository.getReferenceById(id);
        int contentId = film.getContentId();
        Content content = contentRepository.getReferenceById(contentId);

        BeanUtils.copyProperties(film, existingFilm, "id");

        existingFilm.setContent(content);

        return filmRepository.saveAndFlush(existingFilm);
    }
}
