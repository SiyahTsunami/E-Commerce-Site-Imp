package com.dolap.backend.ecommercesite.domain.seller.exceptions;

import com.dolap.backend.ecommercesite.contracts.exception.ECommerceException;

public class SellerAlreadyCreatedException extends ECommerceException {

    public SellerAlreadyCreatedException() {
        super("Seller's username already created.");
    }
}
