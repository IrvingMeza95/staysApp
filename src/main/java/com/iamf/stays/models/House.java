package com.iamf.stays.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class House {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String streetName;
    private Integer houseNumber;
    private String zip;
    private String city;
    private String country;
    @Column(length = 500)
    private String description;
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Temporal(TemporalType.DATE)
    private Date untilDate;
    private Integer minDays;
    private Integer maxDays;
    private Double price;
    @OneToOne
    @JoinColumn(name = "family_id")
    private Family family;
    @Column(length = 500)
    private String image;
    @OneToMany(mappedBy = "house")
    private List<Comment> commentList;
    @OneToMany(mappedBy = "house")
    private List<Stay> stays;
    @ManyToMany(mappedBy = "favList")
    private List<Customer> likes;

}
