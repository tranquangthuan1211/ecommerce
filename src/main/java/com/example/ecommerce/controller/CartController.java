package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.CartRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.service.CartService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    CartService cartService;
    CartController(CartService cartService){
        this.cartService = cartService;
    }
    @PostMapping
    public ApiResponse<Cart> createCart(@RequestBody CartRequest request) {
        System.out.println("1");
        return ApiResponse.<Cart>builder()
                .message("Cart created successfully")
                .code(200)
                .data(cartService.creteCart(request))
                .build();
    }

}
