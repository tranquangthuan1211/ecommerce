package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.AuthenticationRequest;
import com.example.ecommerce.dto.request.UserCreationalRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.dto.response.AuthenticationResponse;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.AuthenticationService;
import com.example.ecommerce.service.UserService;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController {
    @Autowired
    private final AuthenticationService authenticationService;
    private final UserService userService;
    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        System.out.println(1);
        AuthenticationResponse result = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .data(result)
                .message("Login successful")
                .build();
    }
    @PostMapping("/register")
    ApiResponse<User> register(@RequestBody UserCreationalRequest request){
        System.out.println("1");
        User result = userService.createUser(request);
        return ApiResponse.<User>builder()
                .data(result)
                .message("user register successfully")
                .build();
    }

}
