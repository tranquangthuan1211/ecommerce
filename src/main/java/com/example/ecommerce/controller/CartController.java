package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.CartRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.dto.response.CartResponse;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.service.CartService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {
    CartService cartService;
    CartController(CartService cartService){
        this.cartService = cartService;
    }
    @PostMapping
    ApiResponse<Cart> createCart(@RequestBody CartRequest request){
        return ApiResponse.<Cart>builder()
                .data(cartService.createCart(request))
                .code(200)
                .message("create cart successfully")
                .build();
    }
    @GetMapping("/{cartId}")
    ApiResponse<CartResponse> getCartById(@PathVariable String cartId){
        return ApiResponse.<CartResponse>builder()
                .message("get successfully")
                .code(200)
                .data(cartService.getCart(cartId))
                .build();
    }
    @PostMapping("/{cartId}")
    ApiResponse<CartResponse> addToCart(@PathVariable String cartId, @RequestBody CartRequest request){
        return ApiResponse.<CartResponse>builder()
                .message("add successfully")
                .code(200)
                .data(cartService.addToCart(cartId,request))
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
