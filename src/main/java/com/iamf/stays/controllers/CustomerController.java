package com.iamf.stays.controllers;

import com.iamf.stays.dtos.customer.CustomerDTO;
import com.iamf.stays.dtos.house.HouseLoadDTO;
import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.services.CustomerService;
import com.iamf.stays.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/load-customer/{id}")
    public ResponseEntity<CustomerDTO> get(@PathVariable("id") String id){
        return ResponseEntity.ok(customerService.getCustomerDTO(id));
    }

    @PostMapping("/update")
    public ResponseEntity<UserVerified> update(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(customerService.update(customerDTO));
    }

    @PostMapping("/add-to-fav-list/{customerId}/{houseId}")
    public  void addToFavList(@PathVariable("customerId") String customerId, @PathVariable("houseId") String houseId){
        customerService.addToFavList(customerId, houseId);
    }

    @PostMapping("/remove-from-fav-list/{customerId}/{houseId}")
    public  void removeFromFavList(@PathVariable("customerId") String customerId, @PathVariable("houseId") String houseId){
        customerService.removeFromFavList(customerId, houseId);
    }

    @GetMapping("/get-fav-list/{id}")
    public ResponseEntity<List<HouseLoadDTO>> getFavList(@PathVariable("id") String id){
        return ResponseEntity.ok(customerService.getFavList(id));
    }

}
