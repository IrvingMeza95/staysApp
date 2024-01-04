package com.iamf.stays.dtos.stay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StayDTO {
    private String guestId;
    private String houseId;
    private Date fromDate;
    private Date untilDate;
}
