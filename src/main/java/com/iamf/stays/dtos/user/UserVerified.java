package com.iamf.stays.dtos.user;

import com.iamf.stays.enums.Roles;
import com.iamf.stays.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVerified {
    private String id;
    private String name;
    private String email;
    private UserType userType;
    private Roles role;
    private String image;
}
