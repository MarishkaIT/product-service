package com.example.productservice.model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewText;
    private Integer rating;
    @Column(name = "create_at")
    private LocalDate createAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
