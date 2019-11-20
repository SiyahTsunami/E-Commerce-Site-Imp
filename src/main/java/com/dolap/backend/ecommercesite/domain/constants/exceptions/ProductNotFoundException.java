package com.dolap.backend.ecommercesite.domain.constants.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Product not found.");
    }

}
