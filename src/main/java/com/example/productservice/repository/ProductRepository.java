package com.example.productservice.repository;

import com.example.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String name);
    List<Product> findByCategory(String category);
    List<Product> findByBrand(String brand);
    List<Product> findByModel(String model);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:query% OR p.description " +
            "LIKE %:query% OR p.category LIKE %:query% OR p.brand LIKE %:query% OR p.model LIKE %:query%")
    List<Product> searchProducts(@Param("query") String query);
}
