package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Assess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessRepository extends JpaRepository<Assess,String> {
    List<Assess> findByProductId(String productId);
}
