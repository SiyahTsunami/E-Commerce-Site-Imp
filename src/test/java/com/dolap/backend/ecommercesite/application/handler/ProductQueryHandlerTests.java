package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductNotFoundException;
import com.dolap.backend.ecommercesite.domain.product.presentation.GetProductResponseModel;
import com.dolap.backend.ecommercesite.domain.product.query.FindByCategoryQuery;
import com.dolap.backend.ecommercesite.domain.product.query.FindByProductIdQuery;
import com.dolap.backend.ecommercesite.infrastructure.repositories.ProductRepository;
import com.flextrade.jfixture.JFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ProductQueryHandlerTests {

    @InjectMocks
    private ProductQueryHandler productQueryHandler;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Page<Product> productPage;

    private JFixture fixture = new JFixture();

    @After
    public void after() {
        verifyNoMoreInteractions(productRepository, productPage);
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
        Product product = new Product(fixture.create(AddProductCommand.class));

        when(productRepository.findProductByIdAndIsDeletedFalse(findByProductIdQuery.getProductId())).thenReturn(Optional.of(product));

        ResponseModel<Product> getProductResponse = productQueryHandler.query(findByProductIdQuery);

        verify(productRepository).findProductByIdAndIsDeletedFalse(findByProductIdQuery.getProductId());

        Assert.assertEquals(getProductResponse.getResult().getId(), product.getId());
        Assert.assertEquals(getProductResponse.getResult().getName(), product.getName());
        Assert.assertEquals(getProductResponse.getResult().getCategory(), product.getCategory());
        Assert.assertEquals(getProductResponse.getResult().getDescription(), product.getDescription());
        Assert.assertEquals(getProductResponse.getResult().getContent(), product.getContent());
        Assert.assertEquals(getProductResponse.getResult().getBrand(), product.getBrand());
        Assert.assertEquals(getProductResponse.getResult().getUnitPrice(), product.getUnitPrice(), 0);
        Assert.assertEquals(getProductResponse.getResult().getUnitWeight(), product.getUnitWeight(), 0);
        Assert.assertEquals(getProductResponse.getResult().getPhotoUrl(), product.getPhotoUrl());
        Assert.assertEquals(getProductResponse.getResult().getGender(), product.getGender());
        Assert.assertEquals(getProductResponse.getResult().getSellerUsername(), product.getSellerUsername());
        Assert.assertEquals(getProductResponse.getResult().getCreatedDate(), product.getCreatedDate());
        Assert.assertEquals(getProductResponse.getResult().getChangedDate(), product.getChangedDate());
        Assert.assertEquals(getProductResponse.getResult().isDeleted(), product.isDeleted());
    }

    @Test
    public void Should_Get_Products_Where_Group_Category_Successfully() {
        FindByCategoryQuery findByCategoryQuery = fixture.create(FindByCategoryQuery.class);
        List<Product> products = Collections.singletonList(new Product(fixture.create(AddProductCommand.class)));

        Pageable pageable = PageRequest.of(findByCategoryQuery.getPageNo() - 1, findByCategoryQuery.getPageSize());

        when(productPage.getContent()).thenReturn(products);
        when(productRepository.findProductsByCategoryAndIsDeletedFalse(findByCategoryQuery.getCategory(), pageable)).thenReturn(productPage);

        ResponseModel<List<GetProductResponseModel>> getProductResponse = productQueryHandler.getProductsByCategory(findByCategoryQuery);

        verify(productPage).getContent();
        verify(productRepository).findProductsByCategoryAndIsDeletedFalse(findByCategoryQuery.getCategory(), pageable);

        Assert.assertEquals(getProductResponse.getResult().get(0).getName(), products.get(0).getName());
        Assert.assertEquals(getProductResponse.getResult().get(0).getCategory(), products.get(0).getCategory());
        Assert.assertEquals(getProductResponse.getResult().get(0).getDescription(), products.get(0).getDescription());
        Assert.assertEquals(getProductResponse.getResult().get(0).getContent(), products.get(0).getContent());
        Assert.assertEquals(getProductResponse.getResult().get(0).getBrand(), products.get(0).getBrand());
        Assert.assertEquals(getProductResponse.getResult().get(0).getUnitPrice(), products.get(0).getUnitPrice(), 0);
        Assert.assertEquals(getProductResponse.getResult().get(0).getUnitWeight(), products.get(0).getUnitWeight(), 0);
        Assert.assertEquals(getProductResponse.getResult().get(0).getPhotoUrl(), products.get(0).getPhotoUrl());
        Assert.assertEquals(getProductResponse.getResult().get(0).getGender(), products.get(0).getGender());
        Assert.assertEquals(getProductResponse.getResult().get(0).getSellerUsername(), products.get(0).getSellerUsername());
        Assert.assertEquals(getProductResponse.getResult().get(0).getCreatedDate(), products.get(0).getCreatedDate());
    }

}
