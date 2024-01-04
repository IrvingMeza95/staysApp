package com.iamf.stays.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignup {
    private String name;
    private String email;
    private String password;
    private Date uploadDate;
    private Date dropDate;
    private String userType;
    private String role;
    private Boolean enable;
}
