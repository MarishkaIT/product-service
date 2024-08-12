package com.example.productservice.exception;

public class InsufficientInventoryException extends RuntimeException {
    public InsufficientInventoryException(String s) {
        super(s);
    }
}
