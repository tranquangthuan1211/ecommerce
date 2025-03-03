package com.example.ecommerce.dto.request;

import lombok.Data;

@Data
public class PaymentRequest {
    private String cartId;
    private String userId;
}
