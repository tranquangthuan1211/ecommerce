package com.example.ecommerce.dto.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String name;
    private String address;
    private String phone;
    private String password;
}
