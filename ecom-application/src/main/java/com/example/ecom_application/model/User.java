package com.example.ecom_application.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity(name = "User_table")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserRole role=UserRole.CUSTOMER;

    @OneToOne(cascade=CascadeType.ALL,orphanRemoval=true)
    // cascade updates all the details
    @JoinColumn(name="address_id",referencedColumnName = "id")
    // address id is the foreign key pointing to the id xolumn in addresses
    private Address address;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    @CreationTimestamp
    private LocalDateTime createTime;

}
