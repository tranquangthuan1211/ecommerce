package com.example.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id")
    private Product product;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
