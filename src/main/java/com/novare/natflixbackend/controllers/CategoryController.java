package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.models.Category;
import com.novare.natflixbackend.models.Content;
import com.novare.natflixbackend.repositories.CategoryRepository;
import com.novare.natflixbackend.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content_category")
public class CategoryController {
        @Autowired
        private CategoryRepository categoryRepository;

        @GetMapping
        public List<Category> list() { return categoryRepository.findAll(); }

        @GetMapping
        @RequestMapping("{id}")
        public Category get( @PathVariable Integer id ) {
            return categoryRepository.getReferenceById(id);
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Category create( @RequestBody final Category category ) {
            return categoryRepository.saveAndFlush(category);
        }
}
