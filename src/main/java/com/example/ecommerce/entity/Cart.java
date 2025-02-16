package com.example.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.example.ecommerce.entity.Product;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "user",referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items;
}
