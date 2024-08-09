package com.example.productservice.controller;

import com.example.productservice.model.ProductImage;
import com.example.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{id}/images")
public class ProductImageController {

    private ProductService productService;


    @GetMapping
    public List<ProductImage> getImagesForProduct(@PathVariable Long id) {
        return productService.getImagesForProduct(id);
    }

    @PostMapping("/image")
    public ProductImage addImage(@PathVariable Long id, @RequestBody ProductImage image) {
        return productService.addImage(id, image);
    }

    @PutMapping("/{imageId}")
    public ProductImage updateImage(@PathVariable Long imageId, @RequestBody ProductImage image) {
        return productService.updateImage(imageId, image);
    }

    @DeleteMapping("/{imageId}")
    public void deleteImage(@PathVariable Long imageId) {
        productService.deleteImage(imageId);
    }


}
