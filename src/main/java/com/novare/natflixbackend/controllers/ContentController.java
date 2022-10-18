package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.models.Content;
import com.novare.natflixbackend.repositories.ContentRepository;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Content create( @RequestBody final Content content) {
        return contentRepository.saveAndFlush(content);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        // Check for children records before deleting.
        // This deletes only records without children records.
        contentRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Content update(@PathVariable Integer id, @RequestBody Content content) {
        // TODO: Add validation that all attributes are passed in, otherwise return 400 bad payload.
        Content existingContent = contentRepository.getReferenceById(id);
        BeanUtils.copyProperties(content, existingContent, "id");
        return contentRepository.saveAndFlush(existingContent);
    }
}
