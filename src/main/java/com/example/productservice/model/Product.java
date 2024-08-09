package com.example.productservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String description;
    private String category;
    private String brand;
    private String model;
    private Integer stockQuantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
