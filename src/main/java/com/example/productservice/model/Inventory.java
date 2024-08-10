package com.example.productservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Product product;
    private Integer quantity;
    private Boolean isAvailable;
}
