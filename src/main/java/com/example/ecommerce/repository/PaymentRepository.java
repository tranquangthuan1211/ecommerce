package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Payment;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String> {
    Optional<Payment> findByUserId(String userId);
}
