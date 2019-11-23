package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.UpdateProductCommand;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductNotFoundException;
import com.dolap.backend.ecommercesite.domain.product.presentation.GetProductResponseModel;
import com.dolap.backend.ecommercesite.domain.product.query.FindByCategoryQuery;
import com.dolap.backend.ecommercesite.domain.product.query.FindByProductIdQuery;
import com.dolap.backend.ecommercesite.infrastructure.repositories.ProductRepository;
import com.flextrade.jfixture.JFixture;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;

import java.util.*;
import java.util.function.Function;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ProductQueryHandlerTests {

    @InjectMocks
    private ProductQueryHandler productQueryHandler;

    @Mock
    private ProductRepository productRepository;

    private JFixture fixture = new JFixture();

    @After
    public void after() {
        verifyNoMoreInteractions(productRepository);
    }

    @Test(expected = ProductNotFoundException.class)
    public void Should_Catch_ProductNotFoundException_If_Product_Not_Found__When_Get_Product() {
        FindByProductIdQuery findByProductIdQuery = fixture.create(FindByProductIdQuery.class);

        when(productRepository.findProductByIdAndIsDeletedFalse(findByProductIdQuery.getProductId())).thenReturn(Optional.empty());

        try {
            productQueryHandler.query(findByProductIdQuery);
        } finally {
            verify(productRepository).findProductByIdAndIsDeletedFalse(findByProductIdQuery.getProductId());
        }
    }

    @Test
    public void Should_Get_Product_Successfully() {
        FindByProductIdQuery findByProductIdQuery = fixture.create(FindByProductIdQuery.class);

        when(productRepository.findProductByIdAndIsDeletedFalse(findByProductIdQuery.getProductId())).thenReturn(Optional.of(new Product()));

        productQueryHandler.query(findByProductIdQuery);

        verify(productRepository).findProductByIdAndIsDeletedFalse(findByProductIdQuery.getProductId());
    }

    @Test
    public void Should_Get_Products_Where_Group_Category_Successfully() {
        FindByCategoryQuery findByCategoryQuery = fixture.create(FindByCategoryQuery.class);
        List<GetProductResponseModel> products = Collections.singletonList(fixture.create(GetProductResponseModel.class));

        Pageable pageable = PageRequest.of(findByCategoryQuery.getPageNo() - 1, findByCategoryQuery.getPageSize());

        Page<Product> productPage = mock(Page.class);
        when(productRepository.findProductsByCategoryAndIsDeletedFalse(findByCategoryQuery.getCategory(), pageable)).thenReturn(productPage);

        productQueryHandler.getProductsByCategory(findByCategoryQuery);

        verify(productRepository).findProductsByCategoryAndIsDeletedFalse(findByCategoryQuery.getCategory(), pageable);
    }
}
