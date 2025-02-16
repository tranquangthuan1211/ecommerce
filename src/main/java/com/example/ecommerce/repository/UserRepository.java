package com.example.ecommerce.repository;

import com.example.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByPhone(String phone);
    Optional<User> findByPhone(String phone);
    Optional<User> findByName(String name);
    @Query("UPDATE User u SET " +
            "u.name = CASE WHEN :name IS NOT NULL THEN :name ELSE u.name END, " +
            "u.phone = CASE WHEN :phone IS NOT NULL THEN :phone ELSE u.phone END " +
            "WHERE u.id = :id")
    int updateUser(
            @Param("id") String id,
            @Param("name") String name,
            @Param("phone") String phone
    );
}
