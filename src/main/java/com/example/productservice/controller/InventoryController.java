package com.example.productservice.controller;

import com.example.productservice.model.Inventory;
import com.example.productservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private InventoryService inventoryService;

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable Long productId) {
        Inventory inventory = inventoryService.getInventoryByProductId(productId);
        return ResponseEntity.ok(inventory);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateInventory(@PathVariable Long productId, @RequestBody Integer quantity) {
        inventoryService.updateInventory(productId, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{productId}/ availability")
    public ResponseEntity<Boolean> isProductAvailable(@PathVariable Long productId) {
        boolean available = inventoryService.isProductAvailable(productId);
        return ResponseEntity.ok(available);
    }

    @PostMapping("/{productId}/reserve")
    public ResponseEntity<Void> reserveProduct(@PathVariable Long productId, @RequestBody Integer quantity) {
        inventoryService.reserveProduct(productId, quantity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{productId}/cancel-reservation")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long productId, @RequestBody Integer quantity) {
        inventoryService.cancelReservation(productId, quantity);
        return ResponseEntity.ok().build();
    }
}
