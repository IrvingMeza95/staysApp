package com.iamf.stays.mappers;

import com.iamf.stays.dtos.family.FamilyDTO;
import com.iamf.stays.dtos.user.UserSignup;
import com.iamf.stays.enums.Roles;
import com.iamf.stays.enums.UserType;
import com.iamf.stays.models.Family;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FamilyMapper {

    public Family SignupUserToFamily(UserSignup userSignup){
        Family family = new Family();
        family.setName(userSignup.getName());
        family.setEmail(userSignup.getEmail());
        family.setPassword(new BCryptPasswordEncoder().encode(userSignup.getPassword()));
        family.setUploadDate(new Date());
        family.setUserType(UserType.FAMILY);
        if (userSignup.getRole().equals("ADMIN")){
            family.setRole(Roles.ADMIN);
        }else{
            family.setRole(Roles.USER);
        }
        family.setEnable(true);
        return family;
    }

    public FamilyDTO familyToFamilyDTO(Family family){
        FamilyDTO familyDTO = FamilyDTO.builder()
        		.id(family.getId())
        		.name(family.getName())
        		.alias(family.getAlias())
        		.email(family.getEmail())
        		.minAge(family.getMinAge())
        		.maxAge(family.getMaxAge())
        		.childrenNumber(family.getChildrenNumber())
                .image(family.getImage())
        		.build();
        return familyDTO;

    }

    public Family familyDTOToFamily(Family family, FamilyDTO familyDTO){
        family.setMinAge(familyDTO.getMinAge());
        family.setMaxAge(familyDTO.getMaxAge());
        family.setChildrenNumber(familyDTO.getChildrenNumber());
        family.setId(familyDTO.getId());
        family.setName(familyDTO.getName());
        family.setAlias(familyDTO.getAlias());
        family.setEmail(familyDTO.getEmail());
        family.setImage(familyDTO.getImage());
        return family;
    }

}
