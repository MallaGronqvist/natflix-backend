package com.novare.natflixbackend.controllers;

import com.novare.natflixbackend.uploadServices.IStorageService;
import com.novare.natflixbackend.utils.FileUtil;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

// Don't forget define the origins
// @CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class UploadFilesController {
    private static final Logger logger = LoggerFactory.getLogger(UploadFilesController.class);
    private static IStorageService iStorageService;

    public UploadFilesController(IStorageService iStorageService) {

        this.iStorageService = iStorageService;
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename, HttpServletRequest request) {
        Resource file = iStorageService.loadAsResource(filename);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(file.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(file);
    }

    public static String uploadFile(String imageURL){
        // Start process to handle a base64 file
        String imageDataBytes = FileUtil.getImageFromBase64(imageURL);
        // so you get only the image bytes and then decode them:
        byte[] decodedBytes = Base64.decodeBase64(imageDataBytes);
        String image = iStorageService.storeBase64(decodedBytes);
        // End process to handle a base64 file

        String imgUrl = MvcUriComponentsBuilder.fromMethodName(UploadFilesController.class, "getFile", image, null).build().toString();

        return imgUrl;
    }

}
