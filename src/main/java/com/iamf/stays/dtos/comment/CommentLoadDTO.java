package com.iamf.stays.dtos.comment;

import com.iamf.stays.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentLoadDTO {
    private String id;
    private String description;
    private String postedDate;
    private String userId;
    private String userName;
    private String userImage;
    private UserType userType;
    private String houseId;
}
