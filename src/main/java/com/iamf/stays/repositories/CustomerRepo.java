package com.iamf.stays.repositories;

import com.iamf.stays.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
}
