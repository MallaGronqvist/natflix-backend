package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.models.Content;
import com.novare.natflixbackend.models.Series;
import com.novare.natflixbackend.repositories.SeriesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details-series")
public class SeriesController {
    @Autowired
    private SeriesRepository seriesRepository;

    @GetMapping
    public List<Series> list() { return seriesRepository.findAll(); }

    @GetMapping
    @RequestMapping("{content_id}")
    public List<Series> get(@PathVariable Integer content_id) {

        return seriesRepository.findByContentId(content_id);
    }

    @PostMapping({"create"})
    @ResponseStatus(HttpStatus.CREATED)
    public Series create( @RequestBody final Series series) {
        return seriesRepository.saveAndFlush(series);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        seriesRepository.deleteById(id);
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.PUT)
    public Series update(@RequestBody Series series) {
        // TODO: Add validation that all attributes are passed in, otherwise return 400 bad payload.
        Integer id = series.getId();
        Series existingSeries = seriesRepository.getReferenceById(id);
        BeanUtils.copyProperties(series, existingSeries, "id");
        return seriesRepository.saveAndFlush(existingSeries);
    }
}
