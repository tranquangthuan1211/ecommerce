package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.request.UserCreationalRequest;
import com.example.ecommerce.dto.request.UserUpdateRequest;
import com.example.ecommerce.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationalRequest request);
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
