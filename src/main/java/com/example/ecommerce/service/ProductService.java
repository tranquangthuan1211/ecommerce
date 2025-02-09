package com.example.ecommerce.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.ecommerce.configuration.CloudinaryConfig;
import com.example.ecommerce.dto.request.ProductCreationalRequest;
import com.example.ecommerce.entity.Image;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ImageRepository;
import com.example.ecommerce.repository.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@Data
public class ProductService {
    private Cloudinary cloudinary;
    private ImageRepository imageRepository;
    private ProductRepository productRepository;
    public ProductService(Cloudinary cloudinary,ImageRepository imageRepository,ProductRepository productRepository){
        this.cloudinary = cloudinary;
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    public Product createProduct(ProductCreationalRequest request) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(request.getFile().getBytes(),
                ObjectUtils.asMap("folder", "ecommerce")
        );
        Image image = Image.builder()
                .url(uploadResult.get("secure_url").toString())
                .publicId(uploadResult.get("public_id").toString())
                .build();
        image = imageRepository.save(image);

        Product product = Product.builder()
                .category(request.getCategory())
                .price(request.getPrice())
                .name(request.getName())
                .quantity(request.getQuantity())
                .image(image)
                .build();

        return productRepository.save(product);
    }
}
