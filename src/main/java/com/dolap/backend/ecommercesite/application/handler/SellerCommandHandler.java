package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.Seller;
import com.dolap.backend.ecommercesite.domain.seller.command.AddSellerCommand;
import com.dolap.backend.ecommercesite.domain.seller.exceptions.SellerAlreadyCreatedException;
import com.dolap.backend.ecommercesite.domain.seller.presentation.AddSellerResponseModel;
import com.dolap.backend.ecommercesite.infrastructure.repositories.SellerRepository;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellerCommandHandler {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerCommandHandler(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @CommandHandler
    public ResponseModel add(AddSellerCommand command) {
        if (sellerRepository.existsByUsername(command.getUsername())) {
            throw new SellerAlreadyCreatedException();
        }

        Seller seller = new Seller(command);

        sellerRepository.save(seller);

        return new ResponseModel<>(createAddSellerResponseModel(seller));
    }

    private AddSellerResponseModel createAddSellerResponseModel(Seller seller) {
        AddSellerResponseModel addSellerResponseModel = new AddSellerResponseModel();
        addSellerResponseModel.setSellerId(seller.getId());
        addSellerResponseModel.setUsername(seller.getUsername());
        addSellerResponseModel.setCreatedDate(seller.getCreatedDate());
        return addSellerResponseModel;
    }
}
