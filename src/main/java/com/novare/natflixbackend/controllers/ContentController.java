package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.models.Content;
import com.novare.natflixbackend.models.Film;
import com.novare.natflixbackend.models.Series;
import com.novare.natflixbackend.repositories.ContentRepository;
import com.novare.natflixbackend.repositories.FilmRepository;
import com.novare.natflixbackend.repositories.SeriesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentRepository contentRepository;


    @GetMapping
    public List<Content> list() { return contentRepository.findAll(); }

    @GetMapping
    @RequestMapping("{id}")
    public Content get(@PathVariable Integer id) {
        return contentRepository.getReferenceById(id);
    }

    @GetMapping
    @RequestMapping({"series"})
    public List<Content> getSeries() {
        return contentRepository.findByTypeId(1);
    }

    @GetMapping
    @RequestMapping({"movies"})
    public List<Content> getMovies() {
        return contentRepository.findByTypeId(2);
    }

    @GetMapping
    @RequestMapping({"documentaries"})
    public List<Content> getDocumentaries() {
        return contentRepository.findByTypeId(3);
    }

    @PostMapping({"create"})
    @ResponseStatus(HttpStatus.CREATED)
    public Content create( @RequestBody Content content) {
        return contentRepository.saveAndFlush(content);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {

        Content content = contentRepository.getReferenceById(id);

        contentRepository.deleteById(id);
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.PUT)
    public Content update(@RequestBody Content content) {
        // TODO: Add validation that all attributes are passed in, otherwise return 400 bad payload.
        Integer id = content.getId();
        Content existingContent = contentRepository.getReferenceById(id);
/*
        Film film = null;
        if((existingContent.getTypeId() == 2 || existingContent.getTypeId() == 3)
                && existingContent.getFilm() != null) {
            film = existingContent.getFilm();
        }

*/

        BeanUtils.copyProperties(content, existingContent, "id");
/*
        if((existingContent.getTypeId() == 2 || existingContent.getTypeId() == 3)
                && film != null) {
            existingContent.addFilm(film);
        }
*/
        return contentRepository.saveAndFlush(existingContent);
    }
}
