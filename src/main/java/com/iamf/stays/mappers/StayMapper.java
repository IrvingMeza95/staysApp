package com.iamf.stays.mappers;

import com.iamf.stays.dtos.stay.StayLoadDTO;
import com.iamf.stays.models.Stay;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class StayMapper {

    public StayLoadDTO stayToStayLoadDTO(Stay stay) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        if(stay.getFromDate() == null){
            stay.setFromDate(new Date());
        }
        if(stay.getUntilDate() == null){
            stay.setUntilDate(new Date());
        }
        return StayLoadDTO.builder()
                .id(stay.getId())
                .guestId(stay.getGuest().getId())
                .houseId(stay.getHouse().getId())
                .houseImage(stay.getHouse().getImage())
                .country(stay.getHouse().getCountry())
                .city(stay.getHouse().getCity())
                .fromDate(sdf.format(stay.getFromDate()))
                .untilDate(sdf.format(stay.getUntilDate()))
                .build();
    }

    public List<StayLoadDTO> staysToStaysLoadDTOs(List<Stay> stays) {
        List<StayLoadDTO> stayLoadDTOS = new ArrayList<>();
        stays.forEach((s) -> stayLoadDTOS.add(this.stayToStayLoadDTO(s)));
        return stayLoadDTOS;
    }
}
