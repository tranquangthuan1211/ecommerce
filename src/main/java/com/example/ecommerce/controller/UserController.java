package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.UserCreationalRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    ApiResponse<User> createUser(@RequestBody UserCreationalRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get users successfully");
        apiResponse.setData(userService.createUser(request));
        return apiResponse;
    }
    @GetMapping
    ApiResponse<String> getUsers(){
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get users successfully");
        apiResponse.setData("hello");
        return apiResponse;
    }

}
