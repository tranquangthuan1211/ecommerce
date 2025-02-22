package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.FavouriteRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.Favourite;
import com.example.ecommerce.service.FavouriteService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favourites")
@Data
public class FavouriteController {
    private FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService){
        this.favouriteService = favouriteService;
    }

    @PostMapping
    ApiResponse<Favourite> createFavourite(FavouriteRequest request){
        return ApiResponse.<Favourite>builder()
                .message("successfully")
                .code(200)
                .data(favouriteService.createFavourite(request))
                .build();
    }
}
