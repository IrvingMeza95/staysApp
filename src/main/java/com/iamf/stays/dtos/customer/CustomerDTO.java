package com.iamf.stays.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private String id;
    private String email;
    private String name;
    private String alias;
    private String streetName;
    private Integer houseNumber;
    private String zip;
    private String city;
    private String country;
    private String image;

}
