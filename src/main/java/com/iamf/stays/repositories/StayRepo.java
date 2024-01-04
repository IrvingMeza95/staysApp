package com.iamf.stays.repositories;

import com.iamf.stays.models.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayRepo extends JpaRepository<Stay, String> {
    List<Stay> findByGuestId(String id);
}
