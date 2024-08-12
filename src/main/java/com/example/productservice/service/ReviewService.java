package com.example.productservice.service;

import com.example.productservice.exception.ResourceNotFoundException;
import com.example.productservice.model.Product;
import com.example.productservice.model.Review;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;

    public List<Review> getReviewForProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }



    public Review addReviews(Long productId, Review review) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
        review.setProduct(product);
        return reviewRepository.save(review);
    }

    public Review updateReview(Long reviewId, Review review) {
        Review existingReview = reviewRepository.findById(reviewId).orElseThrow(() -> new ResourceNotFoundException("Review not found!"));
        existingReview.setReviewText(review.getReviewText());
        existingReview.setRating(review.getRating());
        return reviewRepository.save(existingReview);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
