package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.ProductCreationalRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Data
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    ProductController (ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    ApiResponse<Product> createProduct(ProductCreationalRequest request) throws IOException {
        return ApiResponse.<Product>builder()
                .data(productService.createProduct(request))
                .message("create product successfully")
                .code(200)
                .build();
    }
}
