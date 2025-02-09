package com.example.ecommerce.dto.request;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductCreationalRequest {
    private String name;
    private String category;
    private String price;
    private int quantity;
    private MultipartFile file;
}
