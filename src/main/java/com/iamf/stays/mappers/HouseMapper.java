package com.iamf.stays.mappers;

import com.iamf.stays.dtos.house.HouseDTO;
import com.iamf.stays.dtos.house.HouseLoadDTO;
import com.iamf.stays.models.Family;
import com.iamf.stays.models.House;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class HouseMapper {

    public House houseDTOToHouse(HouseDTO houseDTO, Family family){
        House house = House.builder()
        		.streetName(houseDTO.getStreetName())
        		.houseNumber(houseDTO.getHouseNumber())
        		.zip(houseDTO.getZip())
        		.city(houseDTO.getCity())
        		.country(houseDTO.getCountry())
				.description(houseDTO.getDescription())
        		.fromDate(houseDTO.getFromDate())
        		.untilDate(houseDTO.getUntilDate())
        		.minDays(houseDTO.getMinDays())
        		.maxDays(houseDTO.getMaxDays())
        		.price(houseDTO.getPrice())
        		.family(family)
				.image(houseDTO.getImage())
        		.build();
        return house;
    }

    public House houseDTOToHouse(HouseDTO houseDTO){
		House house = House.builder()
        		.id(houseDTO.getId())
        		.streetName(houseDTO.getStreetName())
        		.houseNumber(houseDTO.getHouseNumber())
        		.zip(houseDTO.getZip())
        		.city(houseDTO.getCity())
        		.country(houseDTO.getCountry())
				.description(houseDTO.getDescription())
        		.fromDate(houseDTO.getFromDate())
        		.untilDate(houseDTO.getUntilDate())
        		.minDays(houseDTO.getMinDays())
        		.maxDays(houseDTO.getMaxDays())
        		.price(houseDTO.getPrice())
				.image(houseDTO.getImage())
        		.build();
        return house;
    }

    public HouseDTO hoseToHouseDTO(House house){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setId(house.getId());
        houseDTO.setStreetName(house.getStreetName());
        houseDTO.setHouseNumber(house.getHouseNumber());
        houseDTO.setZip(house.getZip());
        houseDTO.setCity(house.getCity());
        houseDTO.setCountry(house.getCountry());
		houseDTO.setDescription(house.getDescription());
        houseDTO.setFromDate(house.getFromDate());
        houseDTO.setUntilDate(house.getUntilDate());
        houseDTO.setMinDays(house.getMinDays());
        houseDTO.setMaxDays(house.getMaxDays());
        houseDTO.setPrice(house.getPrice());
		houseDTO.setImage(house.getImage());
        return houseDTO;
    }

	public HouseLoadDTO houseToHouseLoadDTO(House house){
		if(house.getFromDate() == null){
			house.setFromDate(new Date());
		}
		if(house.getUntilDate() == null){
			house.setUntilDate(new Date());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HouseLoadDTO houseLoadDTO = HouseLoadDTO.builder()
	    		.id(house.getId())
	    		.streetName(house.getStreetName())
	    		.houseNumber(house.getHouseNumber())
	    		.zip(house.getZip())
	    		.city(house.getCity())
	    		.country(house.getCountry())
				.description(house.getDescription())
				.fromDate(sdf.format(house.getFromDate()))
				.untilDate(sdf.format(house.getUntilDate()))
	    		.minDays(house.getMinDays())
	    		.maxDays(house.getMaxDays())
	    		.price(String.valueOf(house.getPrice()))
				.image(house.getImage())
				.familyId(house.getFamily().getId())
				.commentQty(house.getCommentList().size())
				.likes(house.getLikes().size())
	    		.build();
	    return houseLoadDTO;
	}

	public List<HouseLoadDTO> housesToHouseLoadDTOS(List<House> houses){
		List<HouseLoadDTO> houseLoadDTOS = new ArrayList<>();
		houses.forEach((h) -> houseLoadDTOS.add(this.houseToHouseLoadDTO(h)));
		return houseLoadDTOS;
	}

}
