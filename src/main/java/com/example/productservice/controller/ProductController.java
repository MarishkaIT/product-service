package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.model.Review;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search/{query}")
    public List<Product> searchProducts(@PathVariable String query) {
        return productService.searchProducts(query);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/brand/{brand}")
    public List<Product> getProductByBrand(@PathVariable String brand) {
        return productService.getProductsByBrand(brand);
    }

    @GetMapping("/model/{model}")
    public List<Product> getProductByModel(@PathVariable String model) {
        return productService.getProductsByModel(model);
    }

    @GetMapping("/{id}/review")
    public List<Review> getReviewForProduct(@PathVariable Long id) {
        return productService.getReviewForProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("/{id}/reviews")
    public Review addReview(@PathVariable Long id, @RequestBody Review review) {
        return productService.addReviews(id, review);
    }

    @PutMapping("/review/{reviewId}")
    public Review updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        return productService.updateReview(reviewId, review);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @DeleteMapping("/review/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        productService.deleteReview(reviewId);
    }

}
