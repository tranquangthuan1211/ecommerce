package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.UserCreationalRequest;
import com.example.ecommerce.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationalRequest request);
}
