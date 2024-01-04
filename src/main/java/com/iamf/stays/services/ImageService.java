package com.iamf.stays.services;

import com.iamf.stays.models.Image;
import com.iamf.stays.repositories.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepo imageRepo;

    public Image save(MultipartFile file){
        System.out.println("Llego al metodo");
        if(file != null){
            System.out.println("Entro al if");
            try {
                Image image = Image.builder()
                        .mime(file.getContentType())
                        .name(file.getName())
                        .content(file.getBytes())
                        .build();
                return imageRepo.save(image);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
