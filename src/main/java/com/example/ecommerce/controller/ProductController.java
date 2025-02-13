package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.ProductCreationalRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.ProductService;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Data
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    ProductController (ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    ApiResponse<List<Product>> getUsers(){
        ApiResponse<List<Product>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get users successfully");
        apiResponse.setData(productService.getAllProduct());
        return apiResponse;
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
