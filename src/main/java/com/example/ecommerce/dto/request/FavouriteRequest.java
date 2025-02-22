package com.example.ecommerce.dto.request;

import lombok.Data;

@Data
public class FavouriteRequest {
    private String user_id;
    private String product_id;
}
