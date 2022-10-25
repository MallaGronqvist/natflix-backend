package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.models.Content;
import com.novare.natflixbackend.models.Series;
import com.novare.natflixbackend.repositories.ContentRepository;
import com.novare.natflixbackend.repositories.SeriesRepository;
import com.novare.natflixbackend.uploadServices.IStorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("/details-series")
public class SeriesController {
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private ContentRepository contentRepository;
    private final IStorageService iStorageService;

    public SeriesController(IStorageService iStorageService) {
        this.iStorageService = iStorageService;
    }

    @GetMapping
    public List<Series> list() { return seriesRepository.findAll(); }

    @GetMapping
    @RequestMapping("{content_id}")
    public List<Series> get(@PathVariable Integer content_id) {

        return seriesRepository.findByContentId(content_id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Series> create(@RequestBody final Series series) {
        ResponseEntity<Series> BAD_REQUEST = getSeriesResponseEntityForDuplicate(series);
        if (BAD_REQUEST != null) return BAD_REQUEST;

        Integer contentId = series.getContentId();
        Content content = contentRepository.getReferenceById(contentId);
        series.setContent(content);

        if(series.getThumbnailUrl() != null) {
            String thumbnailURL = UploadFilesController.uploadFile(series.getThumbnailUrl());
            series.setThumbnailUrl(thumbnailURL);
        }

        contentRepository.saveAndFlush(content);
        return new ResponseEntity<>(seriesRepository.saveAndFlush(series), HttpStatus.CREATED);
    }

    private ResponseEntity<Series> getSeriesResponseEntityForDuplicate(Series series) {
        // Check if season and episode number already in database
        Series episodeFound = seriesRepository.findByContentIdAndSeasonNumberAndEpisodeNumber(
                series.getContentId(), series.getSeasonNumber(), series.getEpisodeNumber());
        // If found return bad payload
        if(episodeFound != null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        Series series = seriesRepository.getReferenceById(id);
        try {
            String thumbnailUrl = series.getThumbnailUrl();
            iStorageService.delete(thumbnailUrl);
        } catch (Exception e) {

        }

        seriesRepository.deleteById(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Series> update(@RequestBody Series series) {
        // TODO: Add validation that all attributes are passed in, otherwise return 400 bad payload.

        Integer id = series.getId();
        Series existingSeries = seriesRepository.getReferenceById(id);

        if( (existingSeries.getThumbnailUrl() != null
                && series.getThumbnailUrl() != null
                && ! existingSeries.getThumbnailUrl().equals(series.getThumbnailUrl()))
                || (existingSeries.getThumbnailUrl() == null && series.getThumbnailUrl() != null)) {
            String thumbnailURL = UploadFilesController.uploadFile(series.getThumbnailUrl());
            series.setThumbnailUrl(thumbnailURL);
        }

        Integer contentId = series.getContentId();
        Content content = contentRepository.getReferenceById(contentId);
        BeanUtils.copyProperties(series, existingSeries, "id");
        existingSeries.setContent(content);
        return new ResponseEntity<>(seriesRepository.saveAndFlush(existingSeries), HttpStatus.OK);
    }
}
