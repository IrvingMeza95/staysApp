package com.iamf.stays.models;

import com.iamf.stays.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comment {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(length = 1000)
    private String description;
    private Date postedDate;
    private String userId;
    private String userName;
    private String userImage;
    private UserType userType;
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

}
