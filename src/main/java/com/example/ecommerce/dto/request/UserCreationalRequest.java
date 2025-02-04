package com.example.ecommerce.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreationalRequest {
    private String name;
    private String address;
    private String phone;
    private String password;
    private LocalDate dbo;
}
