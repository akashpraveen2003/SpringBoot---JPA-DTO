package com.example.ecom_application.dto;

import com.example.ecom_application.model.UserRole;
import lombok.Data;

@Data
public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private UserRole role;

    private AddressDTO address;
}
