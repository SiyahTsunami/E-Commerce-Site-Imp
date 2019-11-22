package com.dolap.backend.ecommercesite.domain.seller.exceptions;

import com.dolap.backend.ecommercesite.interfaces.ECommerceException;

public class SellerAlreadyCreatedException extends ECommerceException {

    public SellerAlreadyCreatedException() {
        super("Seller username already created.");
    }
}
