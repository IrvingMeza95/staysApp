package com.iamf.stays.services;

import com.iamf.stays.dtos.customer.CustomerDTO;
import com.iamf.stays.dtos.house.HouseLoadDTO;
import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.mappers.CustomerMapper;
import com.iamf.stays.mappers.HouseMapper;
import com.iamf.stays.mappers.UserMapper;
import com.iamf.stays.models.Customer;
import com.iamf.stays.models.House;
import com.iamf.stays.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseMapper houseMapper;

    public CustomerDTO getCustomerDTO(String id){
        Customer customer = customerRepo.findById(id).get();
        return customerMapper.customerToCustomerDTO(customer);
    }

    public UserVerified update(CustomerDTO customerDTO){
        Customer dbCustomer = customerRepo.findById(customerDTO.getId()).get();
        Customer updatedCustomer = customerMapper.customerDTOToCustomer(dbCustomer,customerDTO);
        customerRepo.save(updatedCustomer);
        return userMapper.userToUserVerified(updatedCustomer);
    }

    public Customer findById(String id) {
        return customerRepo.findById(id).get();
    }

    public void addToFavList(String customerId, String houseId) {
        House house = houseService.findById(houseId);
        Customer customer = customerRepo.findById(customerId).get();
        customer.getFavList().add(house);
        customerRepo.save(customer);
    }

    public List<HouseLoadDTO> getFavList(String id) {
        Customer customer = customerRepo.findById(id).get();
        return houseMapper.housesToHouseLoadDTOS(customer.getFavList());
    }

    public void removeFromFavList(String customerId, String houseId) {
        House house = houseService.findById(houseId);
        Customer customer = customerRepo.findById(customerId).get();
        customer.getFavList().remove(house);
        customerRepo.save(customer);
    }
}
