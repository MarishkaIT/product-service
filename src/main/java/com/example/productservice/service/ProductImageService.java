package com.example.productservice.service;

import com.example.productservice.exception.ResourceNotFoundException;
import com.example.productservice.model.Product;
import com.example.productservice.model.ProductImage;
import com.example.productservice.repository.ProductImageRepository;
import com.example.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    private ProductImageRepository imageRepository;
    private ProductRepository productRepository;

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
}
