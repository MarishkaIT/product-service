package com.example.productservice.model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewText;
    private Integer rating;
    private LocalDate createAt;

    @ManyToOne
    private Product product;

}
