package com.iamf.stays.repositories;

import com.iamf.stays.models.Family;
import com.iamf.stays.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepo extends JpaRepository<House, String> {
    @Query(value = "select * from house h where h.family_id = :id", nativeQuery = true)
    Optional<House> findHouseByFamilyId(String id);

    @Query(value = "select * from house h where not exists \n" +
            "(select s.house_id from stay s where s.house_id = h.id and s.guest_id = :customerId)", nativeQuery = true)
    Optional<List<House>> portalPost(@Param("customerId") String customerId);
}
