package com.iamf.stays.controllers;

import com.iamf.stays.dtos.stay.StayDTO;
import com.iamf.stays.dtos.stay.StayLoadDTO;
import com.iamf.stays.services.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stay")
public class StayController {

    @Autowired
    private StayService stayService;

    @PostMapping("/reserve")
    public ResponseEntity<StayLoadDTO> reserve(@RequestBody StayDTO stayDTO){
        return ResponseEntity.ok(stayService.reserve(stayDTO));
    }

    @GetMapping("/get-customer-stays/{id}")
    public List<StayLoadDTO> getCustomerStays(@PathVariable("id") String id){
        return stayService.getCustomerStays(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStay(@PathVariable("id") String id){
        stayService.deleteStay(id);
    }

}
