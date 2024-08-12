package com.example.productservice.service;

import com.example.productservice.exception.InsufficientInventoryException;
import com.example.productservice.model.Inventory;
import com.example.productservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    public InventoryRepository inventoryRepository;

    public Inventory getInventoryByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId).orElseThrow();
    }

    public void updateInventory(Long productId, Integer quantity) {
        Inventory inventory = getInventoryByProductId(productId);
        inventory.setQuantity(quantity);
        inventoryRepository.save(inventory);
    }

    public boolean isProductAvailable(Long productId) {
        Inventory inventory = getInventoryByProductId(productId);
        return inventory.getIsAvailable();
    }

    public void reserveProduct(Long productId, Integer quantity) {
        Inventory inventory = getInventoryByProductId(productId);
        if (inventory.getQuantity() >= quantity) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            inventoryRepository.save(inventory);
        }else {
            throw new InsufficientInventoryException("Insufficient inventory for product " + productId);
        }
    }

    public void cancelReservation(Long productId, Integer quantity) {
        Inventory inventory = getInventoryByProductId(productId);
        inventory.setQuantity(inventory.getQuantity() + quantity);
        inventoryRepository.save(inventory);
    }
}
