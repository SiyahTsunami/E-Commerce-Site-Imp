package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.query.FindByProductIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductQueryHandler {

    @QueryHandler
    public Product get(FindByProductIdQuery query) {
        return new Product();
    }

}
