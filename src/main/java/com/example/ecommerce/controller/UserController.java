package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.UserCreationalRequest;
import com.example.ecommerce.dto.request.UserUpdateRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PreAuthorize("hasRole('ADMIN')")
    ApiResponse<List<User>> getUsers(){
        ApiResponse<List<User>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get users successfully");
        apiResponse.setData(userService.geAllUser());
        return apiResponse;
    }
    @PutMapping("/{userId}")
    ApiResponse<User> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return ApiResponse.<User>builder()
                .data(userService.uploadUser(userId,request))
                .message("user update successfully")
                .code(200)
                .build();
    }

}
