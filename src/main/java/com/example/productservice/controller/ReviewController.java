package com.example.productservice.controller;

import com.example.productservice.model.Review;
import com.example.productservice.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{id}/reviews")
public class ReviewController {

    private ReviewService reviewService;


    @GetMapping
    public List<Review> getReviewForProduct(@PathVariable Long id) {
        return reviewService.getReviewForProduct(id);
    }

    @PostMapping
    public Review addReview(@PathVariable Long id, @RequestBody Review review) {
        return reviewService.addReviews(id, review);
    }

    @PutMapping("/{reviewId}")
    public Review updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        return reviewService.updateReview(reviewId, review);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

}
