package com.iamf.stays.dtos.comment;

import com.iamf.stays.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private String description;
    private Date postedDate;
    private String userId;
    private String userName;
    private String userImage;
    private UserType userType;
    private String houseId;
}
