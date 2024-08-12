package com.example.productservice.controller;

import com.example.productservice.model.ProductImage;
import com.example.productservice.service.ProductImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/{id}/images")
public class ProductImageController {

    private ProductImageService imageService;


    @GetMapping
    public List<ProductImage> getImagesForProduct(@PathVariable Long id) {
        return imageService.getImagesForProduct(id);
    }

    @PostMapping("/image")
    public ProductImage addImage(@PathVariable Long id, @RequestBody ProductImage image) {
        return imageService.addImage(id, image);
    }

    @PutMapping("/{imageId}")
    public ProductImage updateImage(@PathVariable Long imageId, @RequestBody ProductImage image) {
        return imageService.updateImage(imageId, image);
    }

    @DeleteMapping("/{imageId}")
    public void deleteImage(@PathVariable Long imageId) {
        imageService.deleteImage(imageId);
    }



}
