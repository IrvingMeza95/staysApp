package com.iamf.stays.controllers;

import com.iamf.stays.dtos.family.FamilyDTO;
import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/load-family/{id}")
    public ResponseEntity<FamilyDTO> get(@PathVariable("id") String id){
        return ResponseEntity.ok(familyService.get(id));
    }

    @PostMapping("/update")
    public ResponseEntity<UserVerified> update(@RequestBody FamilyDTO familyDTO){
        return ResponseEntity.ok(familyService.update(familyDTO));
    }

}
