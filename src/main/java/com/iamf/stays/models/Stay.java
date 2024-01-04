package com.iamf.stays.models;

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
public class Stay {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Customer guest;
    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Temporal(TemporalType.DATE)
    private Date untilDate;
    private Boolean active;

}
