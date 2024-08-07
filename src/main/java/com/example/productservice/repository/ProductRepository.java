package com.example.productservice.repository;

import com.example.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String name);
    List<Product> findByCategory(String category);
    List<Product> findByBrand(String brand);
    List<Product> findByModel(String model);
}
