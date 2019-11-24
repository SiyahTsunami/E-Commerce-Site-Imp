package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.contracts.models.ResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.Seller;
import com.dolap.backend.ecommercesite.domain.seller.exceptions.SellerNotFoundException;
import com.dolap.backend.ecommercesite.domain.seller.presentation.GetSellerResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.query.FindByUsernameQuery;
import com.dolap.backend.ecommercesite.infrastructure.repositories.SellerRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellerQueryHandler {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerQueryHandler(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @QueryHandler
    public ResponseModel query(FindByUsernameQuery query) {
        Seller seller = sellerRepository.findSellerByUsernameAndIsDeletedFalse(query.getSellerId())
                .orElseThrow(SellerNotFoundException::new);

        return new ResponseModel<>(new GetSellerResponseModel(seller));
    }

}
