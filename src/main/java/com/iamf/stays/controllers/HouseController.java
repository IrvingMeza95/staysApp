package com.iamf.stays.controllers;

import com.iamf.stays.dtos.house.HouseDTO;
import com.iamf.stays.dtos.house.HouseLoadDTO;
import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.models.House;
import com.iamf.stays.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/find-by-family/{id}")
    public ResponseEntity<HouseLoadDTO> findByFamily(@PathVariable("id") String id){
        return ResponseEntity.ok(houseService.findByFamily(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseLoadDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(houseService.findHouseDTOById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<House> save(@RequestBody HouseDTO houseDTO){
        return ResponseEntity.ok(houseService.save(houseDTO));
    }

    @PostMapping("/update")
    public ResponseEntity<HouseLoadDTO> update(@RequestBody HouseDTO houseDTO){

        return ResponseEntity.ok(houseService.update(houseDTO));
    }

    @GetMapping("/posts-portal/{id}")
    public List<HouseLoadDTO> postsPortal(@PathVariable("id") String id){
        return houseService.postsPortal(id);
    }



}
