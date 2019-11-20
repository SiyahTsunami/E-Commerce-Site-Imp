package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.DeleteProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.UpdateProductCommand;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductNotFoundException;
import com.dolap.backend.ecommercesite.domain.product.presentation.AddProductResponse;
import com.dolap.backend.ecommercesite.domain.product.presentation.AddProductResponseModel;
import com.dolap.backend.ecommercesite.infrastructure.repositories.ProductCommandRepository;
import org.axonframework.commandhandling.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandHandler {

    private final ProductCommandRepository productCommandRepository;

    @Autowired
    public ProductCommandHandler(ProductCommandRepository productCommandRepository) {
        this.productCommandRepository = productCommandRepository;
    }

    @CommandHandler
    public AddProductResponse add(AddProductCommand command) {
        Product product = new Product(command);

        productCommandRepository.save(product);

        return new AddProductResponse(createAddProductResponseModel(product));
    }

    @CommandHandler
    public void update(UpdateProductCommand command) {
        Product product = productCommandRepository.findProductById(command.getId())
                .orElseThrow(ProductNotFoundException::new);

        product.update(command);

        productCommandRepository.save(product);
    }

    @CommandHandler
    public void delete(DeleteProductCommand command) {
        Product product = productCommandRepository.findProductById(command.getId())
                .orElseThrow(ProductNotFoundException::new);

        product.delete();

        productCommandRepository.save(product);
    }

    private AddProductResponseModel createAddProductResponseModel(Product product) {
        AddProductResponseModel addProductResponseModel = new AddProductResponseModel();
        addProductResponseModel.setProductId(product.getId());
        addProductResponseModel.setSellerId(product.getSellerId());
        addProductResponseModel.setCreatedDate(product.getCreatedDate());
        return addProductResponseModel;
    }

}
