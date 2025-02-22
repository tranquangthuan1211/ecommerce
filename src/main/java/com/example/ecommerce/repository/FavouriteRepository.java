package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite,String> {
}
