package com.example.ecommerce.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRequest {
    private String phone;
    private String password;
}
