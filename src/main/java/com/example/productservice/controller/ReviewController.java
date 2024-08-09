package com.example.productservice.controller;

import com.example.productservice.model.Review;
import com.example.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{id}/reviews")
public class ReviewController {

    private ProductService productService;


    @GetMapping
    public List<Review> getReviewForProduct(@PathVariable Long id) {
        return productService.getReviewForProduct(id);
    }

    @PostMapping
    public Review addReview(@PathVariable Long id, @RequestBody Review review) {
        return productService.addReviews(id, review);
    }

    @PutMapping("/{reviewId}")
    public Review updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        return productService.updateReview(reviewId, review);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        productService.deleteReview(reviewId);
    }

}
