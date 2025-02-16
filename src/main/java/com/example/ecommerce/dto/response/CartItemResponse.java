package com.example.ecommerce.dto.response;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import lombok.Data;

@Data
public class CartItemResponse {
    private String id;
    private Product product;
    private int quantity;

    public CartItemResponse(CartItem item) {
        this.id = item.getId();
        this.product = item.getProduct();
        this.quantity = item.getQuantity();
    }
}
