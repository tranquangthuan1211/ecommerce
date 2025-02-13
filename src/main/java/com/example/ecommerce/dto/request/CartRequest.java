package com.example.ecommerce.dto.request;

import lombok.Data;

@Data
public class CartRequest {
    private String user_id;
    private String product_id;
    private int quantity;
}
