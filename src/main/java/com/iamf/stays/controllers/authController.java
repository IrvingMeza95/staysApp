package com.iamf.stays.controllers;

import com.iamf.stays.dtos.user.UserLogin;
import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.dtos.user.UserSignup;
import com.iamf.stays.exceptions.MyException;
import com.iamf.stays.security.jwt.JwtResponse;
import com.iamf.stays.security.jwt.JwtService;
import com.iamf.stays.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class authController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signun(@RequestBody UserSignup signUpCustomer){
        return ResponseEntity.ok(userService.signup(signUpCustomer));
    }

    @GetMapping("/verify-token-validity")
    public ResponseEntity<UserVerified> verifyTokenValidity(){
        return ResponseEntity.ok(userService.getUserrVerified());
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLogin userLogin){
        return ResponseEntity.ok(userService.login(userLogin));
    }

}
