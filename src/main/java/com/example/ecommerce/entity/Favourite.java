package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
