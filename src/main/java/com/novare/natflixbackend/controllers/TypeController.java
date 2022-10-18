package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.models.Category;
import com.novare.natflixbackend.models.Type;
import com.novare.natflixbackend.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content_type")
public class TypeController {
    @Autowired
    private TypeRepository typeRepository;

    @GetMapping
    public List<Type> list() { return typeRepository.findAll(); }

    @GetMapping
    @RequestMapping("{id}")
    public Type get( @PathVariable Integer id ) {
        return typeRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Type create( @RequestBody final Type type ) {
        return typeRepository.saveAndFlush(type);
    }
}
