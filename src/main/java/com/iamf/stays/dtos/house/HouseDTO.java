package com.iamf.stays.dtos.house;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseDTO {
    private String id;
    private String streetName;
    private Integer houseNumber;
    private String zip;
    private String city;
    private String country;
    private String description;
    private Date fromDate;
    private Date untilDate;
    private Integer minDays;
    private Integer maxDays;
    private Double price;
    private String image;
}
