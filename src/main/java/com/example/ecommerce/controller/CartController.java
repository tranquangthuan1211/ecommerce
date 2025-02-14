package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.CartRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.service.CartService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {
    CartService cartService;
    CartController(CartService cartService){
        this.cartService = cartService;
    }
    @PostMapping
    ApiResponse<Cart> addToCart(@RequestBody CartRequest request){

        return ApiResponse.<Cart>builder()
                .message("add successfully")
                .code(200)
                .data(cartService.addToCart(request))
                .build();
    }
    @DeleteMapping("/{cartId}")
    ApiResponse<Cart> clearItem(@PathVariable String cartId){
        cartService.clearCartItem(cartId);
        return ApiResponse.<Cart>builder()
                .message("pay successfully")
                .code(200)
                .data(null)
                .build();
    }
}
