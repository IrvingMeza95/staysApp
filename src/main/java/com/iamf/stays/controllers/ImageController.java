package com.iamf.stays.controllers;

import com.iamf.stays.models.Image;
import com.iamf.stays.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public void save(@RequestBody MultipartFile file){
        ResponseEntity.ok(imageService.save(file));
    }

}
