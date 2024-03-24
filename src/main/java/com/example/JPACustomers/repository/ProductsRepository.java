package com.example.JPACustomers.repository;

import com.example.JPACustomers.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    Products deleteAllById(Long id);

    Optional<Products> findByName(String name);
}
