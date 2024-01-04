package com.iamf.stays.dtos.family;

import com.iamf.stays.models.House;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FamilyDTO {
    private String id;
    private String name;
    private String alias;
    private String email;
    private Integer minAge;
    private Integer maxAge;
    private Integer childrenNumber;
    private String image;
}
