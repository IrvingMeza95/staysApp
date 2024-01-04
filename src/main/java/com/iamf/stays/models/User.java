package com.iamf.stays.models;

import com.iamf.stays.enums.Roles;
import com.iamf.stays.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    protected String name;
    protected String alias;
    @Column(nullable = false, unique = false)
    protected String email;
    protected String password;
   @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date uploadDate;
    @Temporal(TemporalType.DATE)
    protected Date dropDate;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Enumerated(EnumType.STRING)
    protected Roles role;
    private String image;
    @OneToMany
    private List<Comment> comments;
    protected Boolean enable;
    protected Boolean credentialsNonExpired;

}
