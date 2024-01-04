package com.iamf.stays.services;

import com.iamf.stays.dtos.family.FamilyDTO;
import com.iamf.stays.dtos.user.UserVerified;
import com.iamf.stays.mappers.FamilyMapper;
import com.iamf.stays.mappers.UserMapper;
import com.iamf.stays.models.Family;
import com.iamf.stays.repositories.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FamilyRepo familyRepo;
    @Autowired
    private FamilyMapper familyMapper;

    public FamilyDTO get(String id){
        Family family = familyRepo.findById(id).get();
        return familyMapper.familyToFamilyDTO(family);
    }

    public UserVerified update(FamilyDTO familyDTO){
        Family dbFamily = familyRepo.findById(familyDTO.getId()).get();
        Family updateFamily = familyMapper.familyDTOToFamily(dbFamily,familyDTO);
        familyRepo.save(updateFamily);
        return userMapper.userToUserVerified(updateFamily);
    }

    public void save(Family family){
        familyRepo.save(family);
    }
    
    public Family findById(String id){
        return familyRepo.findById(id).get();
    }

}
