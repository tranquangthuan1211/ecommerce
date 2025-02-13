package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user",referencedColumnName = "id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartItem", referencedColumnName = "id")
    private Set<CartItem> items;
}
