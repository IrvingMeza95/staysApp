package com.iamf.stays.services;

import com.iamf.stays.dtos.house.HouseDTO;
import com.iamf.stays.dtos.house.HouseLoadDTO;
import com.iamf.stays.mappers.HouseMapper;
import com.iamf.stays.models.Family;
import com.iamf.stays.models.House;
import com.iamf.stays.repositories.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepo houseRepo;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private FamilyService familyService;

    public HouseLoadDTO findByFamily(String id){
        House house = houseRepo.findHouseByFamilyId(id).get();
        return houseMapper.houseToHouseLoadDTO(house);
    }

    public HouseLoadDTO findHouseDTOById(String id){
        House house = houseRepo.findById(id).get();
        return houseMapper.houseToHouseLoadDTO(house);
    }

    public House save(HouseDTO houseDTO){
        Family family = familyService.findById(houseDTO.getId());
        House house = houseMapper.houseDTOToHouse(houseDTO,family);
        houseRepo.save(house);
        return house;
    }

    public HouseLoadDTO update(HouseDTO houseDTO){
        System.out.println(houseDTO.toString());
        House bdHouse = houseRepo.findById(houseDTO.getId()).get();
        House updatedHouse = houseMapper.houseDTOToHouse(houseDTO);
        updatedHouse.setFamily(bdHouse.getFamily());
        houseRepo.save(updatedHouse);
        return houseMapper.houseToHouseLoadDTO(updatedHouse);
    }

    public List<HouseLoadDTO> postsPortal(String id) {
        List<HouseLoadDTO> houseLoadDTOS = houseMapper.housesToHouseLoadDTOS(houseRepo.portalPost(id).get());
        return houseLoadDTOS;
    }


    public House findById(String houseId) {
        return houseRepo.findById(houseId).get();
    }

}
