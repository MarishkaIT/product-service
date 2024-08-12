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
    private InventoryService inventoryService;


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
         productRepository.save(product);
         inventoryService.updateInventory(product.getId(), 0);
         return product;
    }

    public Product updateProduct(Long id, Product product) {
        getProductById(id);
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long id) {
        getProductById(id);
        productRepository.deleteById(id);
        inventoryService.updateInventory(id,0);
    }

    public boolean isProductAvailable(Long productId) {
        return inventoryService.isProductAvailable(productId);
    }
}
