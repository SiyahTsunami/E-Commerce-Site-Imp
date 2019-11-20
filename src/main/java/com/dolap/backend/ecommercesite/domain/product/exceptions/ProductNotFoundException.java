package com.dolap.backend.ecommercesite.domain.product.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Product not found.");
    }

}
