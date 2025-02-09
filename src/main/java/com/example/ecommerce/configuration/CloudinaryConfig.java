package com.example.ecommerce.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.cloud-name}")
    private String cloundName;
    @Value("${cloudinary.api-key}")
    private String key;
    @Value("${cloudinary.api-secret-key}")
    private String secretKey;
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloundName,
                "api_key", key,
                "api_secret", secretKey
        ));
    }
}
