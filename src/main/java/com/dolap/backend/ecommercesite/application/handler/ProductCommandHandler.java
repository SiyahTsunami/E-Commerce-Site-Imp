package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.DeleteProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.UpdateProductCommand;
import com.dolap.backend.ecommercesite.domain.product.presentation.AddProductResponse;
import com.dolap.backend.ecommercesite.infrastructure.repositories.ProductCommandRespository;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandHandler {

    private final ProductCommandRespository productCommandRespository;

    @Autowired
    public ProductCommandHandler(ProductCommandRespository productCommandRespository) {
        this.productCommandRespository = productCommandRespository;
    }

    @CommandHandler
    public AddProductResponse add(AddProductCommand command) {
        Product product = new Product(command);

        productCommandRespository.save(product);

        return new AddProductResponse(product.getId());
    }

    @CommandHandler
    public void update(UpdateProductCommand command) {

    }

    @CommandHandler
    public void delete(DeleteProductCommand command) {

    }

}
