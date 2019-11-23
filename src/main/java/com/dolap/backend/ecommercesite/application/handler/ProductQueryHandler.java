package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductNotFoundException;
import com.dolap.backend.ecommercesite.domain.product.presentation.GetProductResponseModel;
import com.dolap.backend.ecommercesite.domain.product.query.FindByCategoryQuery;
import com.dolap.backend.ecommercesite.domain.product.query.FindByProductIdQuery;
import com.dolap.backend.ecommercesite.infrastructure.repositories.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    @Autowired
    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public ResponseModel query(FindByProductIdQuery query) {
        Product product = productRepository.findProductByIdAndIsDeletedFalse(query.getProductId())
                .orElseThrow(ProductNotFoundException::new);

        return new ResponseModel<>(new GetProductResponseModel(product));
    }

    @QueryHandler
    public ResponseModel getProductsByCategory(FindByCategoryQuery query) {
        Pageable pageable = PageRequest.of(query.getPageNo() - 1, query.getPageSize());

        List<GetProductResponseModel> products = productRepository.findProductsByCategoryAndIsDeletedFalse(query.getCategory(), pageable)
                .getContent()
                .stream().map(GetProductResponseModel::new)
                .collect(Collectors.toList());

        return new ResponseModel<>(products);
    }

}
