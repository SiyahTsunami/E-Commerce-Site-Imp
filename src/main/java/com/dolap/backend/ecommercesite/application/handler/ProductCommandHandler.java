package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.DeleteProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.UpdateProductCommand;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductAlreadyCreatedException;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductNotFoundException;
import com.dolap.backend.ecommercesite.domain.product.presentation.AddProductResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.exceptions.SellerNotFoundException;
import com.dolap.backend.ecommercesite.domain.seller.presentation.AddSellerResponseModel;
import com.dolap.backend.ecommercesite.infrastructure.repositories.ProductRepository;
import com.dolap.backend.ecommercesite.infrastructure.repositories.SellerRepository;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandHandler {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;

    @Autowired
    public ProductCommandHandler(ProductRepository productRepository, SellerRepository sellerRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
    }

    @CommandHandler
    public ResponseModel add(AddProductCommand command) {
        if (!sellerRepository.existsSellerByUsernameAndIsDeletedFalse(command.getSellerUsername())) {
            throw new SellerNotFoundException();
        }
        if (productRepository.existsProductByNameAndSellerUsernameAndIsDeletedFalse(command.getName(), command.getSellerUsername())) {
            throw new ProductAlreadyCreatedException();
        }

        Product product = new Product(command);

        productRepository.save(product);

        return new ResponseModel<>(new AddProductResponseModel(product));
    }

    @CommandHandler
    public void update(UpdateProductCommand command) {
        Product product = productRepository.findProductByIdAndIsDeletedFalse(command.getId())
                .orElseThrow(ProductNotFoundException::new);

        product.update(command);

        productRepository.save(product);
    }

    @CommandHandler
    public void delete(DeleteProductCommand command) {
        Product product = productRepository.findProductByIdAndIsDeletedFalse(command.getId())
                .orElseThrow(ProductNotFoundException::new);

        product.delete();

        productRepository.save(product);
    }

}
