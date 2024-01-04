package com.iamf.stays.mappers;

import com.iamf.stays.dtos.user.UserSignup;
import com.iamf.stays.dtos.customer.CustomerDTO;
import com.iamf.stays.enums.Roles;
import com.iamf.stays.enums.UserType;
import com.iamf.stays.models.Customer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerMapper {

    public Customer SignupUserToCustomer(UserSignup userSignup){
        Customer customer = new Customer();
        customer.setName(userSignup.getName());
        customer.setEmail(userSignup.getEmail());
        customer.setPassword(new BCryptPasswordEncoder().encode(userSignup.getPassword()));
        customer.setUploadDate(new Date());
        customer.setUserType(UserType.CUSTOMER);
        if (userSignup.getRole().equals("ADMIN")){
            customer.setRole(Roles.ADMIN);
        }else{
            customer.setRole(Roles.USER);
        }
        customer.setEnable(true);
        return customer;
    }

    public Customer customerDTOToCustomer(Customer customer, CustomerDTO customerDTO){
        customer.setStreetName(customerDTO.getStreetName());
        customer.setHouseNumber(customerDTO.getHouseNumber());
        customer.setZip(customerDTO.getZip());
        customer.setCity(customerDTO.getCity());
        customer.setCountry(customerDTO.getCountry());
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setAlias(customerDTO.getAlias());
        customer.setEmail(customerDTO.getEmail());
        customer.setImage(customerDTO.getImage());
        return customer;
    }

    public CustomerDTO customerToCustomerDTO(Customer customer){
        CustomerDTO customerDTO = CustomerDTO.builder()
        		.id(customer.getId())
        		.email(customer.getEmail())
        		.name(customer.getName())
        		.alias(customer.getAlias())
        		.streetName(customer.getStreetName())
        		.houseNumber(customer.getHouseNumber())
        		.zip(customer.getZip())
        		.city(customer.getCity())
        		.country(customer.getCountry())
                .image(customer.getImage())
        		.build();
        return customerDTO;
    }

}
