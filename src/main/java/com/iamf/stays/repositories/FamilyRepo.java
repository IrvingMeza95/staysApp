package com.iamf.stays.repositories;

import com.iamf.stays.models.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamilyRepo extends JpaRepository<Family, String> {
    Optional<Family> findByEmail(String email);
}
