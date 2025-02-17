package com.example.ecommerce.dto.request;

import lombok.Data;

@Data
public class AssessRequest {
    private String user_id;
    private String product_id;
    private String comment;
}
