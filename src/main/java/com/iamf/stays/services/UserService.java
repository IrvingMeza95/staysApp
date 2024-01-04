package com.iamf.stays.services;

import com.iamf.stays.dtos.user.UserLogin;
import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.dtos.user.UserSignup;
import com.iamf.stays.exceptions.MyException;
import com.iamf.stays.mappers.CustomerMapper;
import com.iamf.stays.mappers.FamilyMapper;
import com.iamf.stays.mappers.UserMapper;
import com.iamf.stays.models.Customer;
import com.iamf.stays.models.Family;
import com.iamf.stays.models.User;
import com.iamf.stays.repositories.CustomerRepo;
import com.iamf.stays.repositories.FamilyRepo;
import com.iamf.stays.security.jwt.JwtResponse;
import com.iamf.stays.security.jwt.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private FamilyRepo familyRepo;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FamilyMapper familyMapper;
    @Autowired
    private JwtService jwtService;

    @Transactional
    public JwtResponse signup(UserSignup userSignup){
        if (userSignup.getUserType().equalsIgnoreCase("customer")){
            return JwtResponse.builder()
                    .token(jwtService.getToken(customerRepo.save(customerMapper.SignupUserToCustomer(userSignup))))
                    .build();
        }

        if (userSignup.getUserType().equalsIgnoreCase("family")){
            return JwtResponse.builder()
                    .token(jwtService.getToken(familyRepo.save(familyMapper.SignupUserToFamily(userSignup))))
                    .build();
        }
        return null;
    }

    public JwtResponse login(UserLogin userLogin) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String token;
        Optional<Customer> dbCustomer = customerRepo.findByEmail(userLogin.getEmail());
        if (dbCustomer.isPresent()){
            Customer customer = dbCustomer.get();
            if (bCryptPasswordEncoder.matches(userLogin.getPassword(), customer.getPassword())){
                token = jwtService.getToken(customer);
                return JwtResponse.builder()
                        .token(token)
                        .build();
            }
        }

        Optional<Family> dbfamily = familyRepo.findByEmail(userLogin.getEmail());
        if (dbfamily.isPresent()){
            Family family = dbfamily.get();
            if (bCryptPasswordEncoder.matches(userLogin.getPassword(), family.getPassword())){
                token = jwtService.getToken(family);
                return JwtResponse.builder()
                        .token(token)
                        .build();
            }
        }
        return (JwtResponse) ResponseEntity.badRequest();
    }

    public UserVerified getUserrVerified(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return UserVerified.builder()
                .id(((User)user).getId())
                .name(((User)user).getName())
                .email(((User)user).getEmail())
                .userType(((User)user).getUserType())
                .role(((User)user).getRole())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepo.findByEmail(email);
        if (customer.isPresent()){
            return customer.get();
        }
        Optional<Family> family = familyRepo.findByEmail(email);
        if (family.isPresent()){
            return family.get();
        }
        return null;
    }

    public List<UserVerified> getAll() {
        List<UserVerified> users = new ArrayList<>();
        List<Customer> customers = customerRepo.findAll();
        users.addAll(userMapper.customersToUsersVerified(customers));
        List<Family> families = familyRepo.findAll();
        users.addAll(userMapper.familiesToUsersVerified(families));
        return users;
    }
}
