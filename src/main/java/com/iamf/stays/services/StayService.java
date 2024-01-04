package com.iamf.stays.services;

import com.iamf.stays.dtos.stay.StayDTO;
import com.iamf.stays.dtos.stay.StayLoadDTO;
import com.iamf.stays.mappers.StayMapper;
import com.iamf.stays.models.Customer;
import com.iamf.stays.models.House;
import com.iamf.stays.models.Stay;
import com.iamf.stays.repositories.CustomerRepo;
import com.iamf.stays.repositories.HouseRepo;
import com.iamf.stays.repositories.StayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StayService {

    @Autowired
    private StayRepo stayRepo;
    @Autowired
    private StayMapper stayMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private HouseRepo houseRepo;

    public StayLoadDTO reserve(StayDTO stayDTO) {
        Customer customer = customerRepo.findById(stayDTO.getGuestId()).get();
        House house = houseRepo.findById(stayDTO.getHouseId()).get();
        Stay stay = Stay.builder()
                .guest(customer)
                .house(house)
                .fromDate(stayDTO.getFromDate())
                .untilDate(stayDTO.getUntilDate())
                .active(true)
                .build();
        stayRepo.save(stay);
        return stayMapper.stayToStayLoadDTO(stay);
    }

    public List<StayLoadDTO> getCustomerStays(String id) {
        return stayMapper.staysToStaysLoadDTOs(stayRepo.findByGuestId(id));
    }

    public void deleteStay(String id) {
        stayRepo.deleteById(id);
    }
}
