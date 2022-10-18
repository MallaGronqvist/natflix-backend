package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.models.Film;
import com.novare.natflixbackend.models.Series;
import com.novare.natflixbackend.repositories.SeriesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details_series")
public class SeriesController {
    @Autowired
    private SeriesRepository seriesRepository;

    @GetMapping
    public List<Series> list() { return seriesRepository.findAll(); }

    @GetMapping
    @RequestMapping("{id}")
    public Series get(@PathVariable Integer id) {
        return seriesRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Series create( @RequestBody final Series series) {
        return seriesRepository.saveAndFlush(series);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        seriesRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Series update(@PathVariable Integer id, @RequestBody Series series) {
        // TODO: Add validation that all attributes are passed in, otherwise return 400 bad payload.
        Series existingSeries = seriesRepository.getReferenceById(id);
        BeanUtils.copyProperties(series, existingSeries, "id");
        return seriesRepository.saveAndFlush(existingSeries);
    }
}
