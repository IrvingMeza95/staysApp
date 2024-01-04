package com.iamf.stays.dtos.house;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseLoadDTO {
    private String id;
    private String streetName;
    private Integer houseNumber;
    private String zip;
    private String city;
    private String country;
    private String description;
    private String fromDate;
    private String untilDate;
    private Integer minDays;
    private Integer maxDays;
    private String price;
    private String image;
    private String familyId;
    private Integer commentQty;
    private Integer likes;
}
