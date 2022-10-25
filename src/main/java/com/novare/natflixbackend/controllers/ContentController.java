package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.models.Content;
import com.novare.natflixbackend.repositories.ContentRepository;
import com.novare.natflixbackend.uploadServices.IStorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentRepository contentRepository;
    private final IStorageService iStorageService;

    public ContentController(IStorageService iStorageService) {
        this.iStorageService = iStorageService;
    }

    @GetMapping
    public List<Content> list() { return contentRepository.findAll(); }

    @GetMapping
    @RequestMapping("{id}")
    public Content get(@PathVariable Integer id) {
        return contentRepository.getReferenceById(id);
    }

    @GetMapping
    @RequestMapping("series")
    public List<Content> getSeries() {
        return contentRepository.findByTypeId(1);
    }

    @GetMapping
    @RequestMapping("movies")
    public List<Content> getMovies() {
        return contentRepository.findByTypeId(2);
    }

    @GetMapping
    @RequestMapping("documentaries")
    public List<Content> getDocumentaries() {
        return contentRepository.findByTypeId(3);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Content> create(@RequestBody Content content) {
        if(content.getLogoUrl() != null) {
            String logoURL = UploadFilesController.uploadFile(content.getLogoUrl());
            content.setLogoUrl(logoURL);
        }
        if(content.getBannerUrl() != null) {
            String bannerURL = UploadFilesController.uploadFile(content.getBannerUrl());
            content.setBannerUrl(bannerURL);
        }
        if(content.getThumbnailUrl() != null) {
            String thumbnailURL = UploadFilesController.uploadFile(content.getThumbnailUrl());
            content.setThumbnailUrl(thumbnailURL);
        }

        return new ResponseEntity<>(contentRepository.saveAndFlush(content), HttpStatus.CREATED);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {

        Content content = contentRepository.getReferenceById(id);
        try {
            iStorageService.delete(content.getLogoUrl());
            iStorageService.delete(content.getBannerUrl());
            iStorageService.delete(content.getThumbnailUrl());
        } catch (Exception e) {

        }

        contentRepository.deleteById(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Content update(@RequestBody Content content) {
        // TODO: Add validation that all attributes are passed in, otherwise return 400 bad payload.
        Integer id = content.getId();
        Content existingContent = contentRepository.getReferenceById(id);

        // If image paths don't match, upload new image
        if( (existingContent.getLogoUrl() != null
                && content.getLogoUrl() != null
                && ! existingContent.getLogoUrl().equals(content.getLogoUrl()))
                || (existingContent.getLogoUrl() == null && content.getLogoUrl() != null)) {
            String logoURL = UploadFilesController.uploadFile(content.getLogoUrl());
            content.setLogoUrl(logoURL);
        }

        if( (existingContent.getBannerUrl() != null
                && content.getBannerUrl() != null
                && ! existingContent.getBannerUrl().equals(content.getBannerUrl()))
                || (existingContent.getBannerUrl() == null && content.getBannerUrl() != null)) {
            String bannerURL = UploadFilesController.uploadFile(content.getBannerUrl());
            content.setBannerUrl(bannerURL);
        }

        if( (existingContent.getThumbnailUrl() != null
                && content.getThumbnailUrl() != null
                && ! existingContent.getThumbnailUrl().equals(content.getThumbnailUrl()))
                || (existingContent.getThumbnailUrl() == null && content.getThumbnailUrl() != null)) {
            String thumbnailURL = UploadFilesController.uploadFile(content.getThumbnailUrl());
            content.setThumbnailUrl(thumbnailURL);
        }

        BeanUtils.copyProperties(content, existingContent, "id");

        return contentRepository.saveAndFlush(existingContent);
    }
}
