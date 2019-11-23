package com.dolap.backend.ecommercesite.domain.product.exceptions;

import com.dolap.backend.ecommercesite.interfaces.ECommerceException;

public class ProductAlreadyCreatedException extends ECommerceException {

    public ProductAlreadyCreatedException() {
        super("Seller's product already created.");
    }
}
