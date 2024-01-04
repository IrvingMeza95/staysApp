package com.iamf.stays.controllers;

import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.models.Customer;
import com.iamf.stays.models.User;
import com.iamf.stays.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public List<UserVerified> getAll(){
        return userService.getAll();
    }

}
