package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductNotFoundException;
import com.dolap.backend.ecommercesite.domain.product.presentation.ProductResponse;
import com.dolap.backend.ecommercesite.domain.product.query.FindByProductIdQuery;
import com.dolap.backend.ecommercesite.infrastructure.repositories.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    @Autowired
    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public ProductResponse get(FindByProductIdQuery query) {
        Product product = productRepository.findProductById(query.getProductId())
                .orElseThrow(ProductNotFoundException::new);

        return new ProductResponse<>(product);
    }

}
