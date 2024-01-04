package com.iamf.stays.dtos.stay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StayLoadDTO {
    private String id;
    private String guestId;
    private String houseId;
    private String houseImage;
    private String country;
    private String city;
    private String fromDate;
    private String untilDate;
}
