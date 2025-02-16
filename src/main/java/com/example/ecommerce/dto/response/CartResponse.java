package com.example.ecommerce.dto.response;

import com.example.ecommerce.entity.Cart;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartResponse {
    private String id;
    private List<CartItemResponse> items;

    public CartResponse(Cart cart) {
        this.id = cart.getId();
        this.items = cart.getItems().stream()
                .map(CartItemResponse::new)
                .collect(Collectors.toList());
    }

}
