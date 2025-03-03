package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  String id;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @OneToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;
}
