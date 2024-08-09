package com.example.productservice.service;

import com.example.productservice.exception.ResourceNotFoundException;
import com.example.productservice.model.Product;
import com.example.productservice.model.ProductImage;
import com.example.productservice.model.Review;
import com.example.productservice.repository.ProductImageRepository;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductImageRepository imageRepository;

    public List<Review> getReviewForProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public List<ProductImage> getImagesForProduct(Long productId) {
        return imageRepository.findByProductId(productId);
    }

    public ProductImage addImage(Long productId, ProductImage image){
        Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product not found!"));
        image.setProduct(product);
        return imageRepository.save(image);
    }

    public ProductImage updateImage(Long imageId, ProductImage image) {
        ProductImage existImage = imageRepository.findById(imageId).orElseThrow(()-> new ResourceNotFoundException("Image not found!"));
        existImage.setImageUrl(image.getImageUrl());
        existImage.setImageType(image.getImageType());
        return imageRepository.save(existImage);
    }

    public void deleteImage(Long imageId) {
        imageRepository.deleteById(imageId);
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

    public List<Product> searchProducts(String query) {
        return productRepository.searchProducts(query);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found!"));
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    public List<Product> getProductsByModel(String model) {
        return productRepository.findByModel(model);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        getProductById(id);
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        getProductById(id);
        productRepository.deleteById(id);
    }
}
