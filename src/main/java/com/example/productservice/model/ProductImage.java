package com.example.productservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "image_type")
    private String imageType;
    @Column(name = "create_at")
    private LocalDate createAt;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
