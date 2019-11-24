package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.contracts.models.ResponseModel;
import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.command.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.command.DeleteProductCommand;
import com.dolap.backend.ecommercesite.domain.product.command.UpdateProductCommand;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductAlreadyCreatedException;
import com.dolap.backend.ecommercesite.domain.product.exceptions.ProductNotFoundException;
import com.dolap.backend.ecommercesite.domain.product.presentation.AddProductResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.exceptions.SellerNotFoundException;
import com.dolap.backend.ecommercesite.infrastructure.repositories.ProductRepository;
import com.dolap.backend.ecommercesite.infrastructure.repositories.SellerRepository;
import com.flextrade.jfixture.JFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductCommandHandlerTests {

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor;
    @InjectMocks
    private ProductCommandHandler productCommandHandler;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private SellerRepository sellerRepository;
    private JFixture fixture = new JFixture();

    @After
    public void after() {
        verifyNoMoreInteractions(productRepository, sellerRepository);
    }

    @Test(expected = SellerNotFoundException.class)
    public void Should_Catch_SellerNotFoundException_If_SellerUsername_Not_Found_When_Add_Product() {
        AddProductCommand addProductCommand = fixture.create(AddProductCommand.class);

        when(sellerRepository.existsSellerByUsernameAndIsDeletedFalse(addProductCommand.getSellerUsername())).thenReturn(false);

        try {
            productCommandHandler.add(addProductCommand);
        } finally {
            verify(sellerRepository).existsSellerByUsernameAndIsDeletedFalse(addProductCommand.getSellerUsername());
        }
    }

    @Test(expected = ProductAlreadyCreatedException.class)
    public void Should_Catch_ProductAlreadyCreatedException_If_Product_Already_Created_For_Same_Seller_When_Add_Product() {
        AddProductCommand addProductCommand = fixture.create(AddProductCommand.class);

        when(sellerRepository.existsSellerByUsernameAndIsDeletedFalse(addProductCommand.getSellerUsername())).thenReturn(true);
        when(productRepository.existsProductByNameAndSellerUsernameAndIsDeletedFalse(addProductCommand.getName(), addProductCommand.getSellerUsername())).thenReturn(true);

        try {
            productCommandHandler.add(addProductCommand);
        } finally {
            verify(sellerRepository).existsSellerByUsernameAndIsDeletedFalse(addProductCommand.getSellerUsername());
            verify(productRepository).existsProductByNameAndSellerUsernameAndIsDeletedFalse(addProductCommand.getName(), addProductCommand.getSellerUsername());
        }
    }

    @Test
    public void Should_Add_Product_Successfully() {
        AddProductCommand addProductCommand = fixture.create(AddProductCommand.class);

        when(sellerRepository.existsSellerByUsernameAndIsDeletedFalse(addProductCommand.getSellerUsername())).thenReturn(true);
        when(productRepository.existsProductByNameAndSellerUsernameAndIsDeletedFalse(addProductCommand.getName(), addProductCommand.getSellerUsername())).thenReturn(false);

        ResponseModel<AddProductResponseModel> addProductResponse = productCommandHandler.add(addProductCommand);

        verify(sellerRepository).existsSellerByUsernameAndIsDeletedFalse(addProductCommand.getSellerUsername());
        verify(productRepository).existsProductByNameAndSellerUsernameAndIsDeletedFalse(addProductCommand.getName(), addProductCommand.getSellerUsername());
        verify(productRepository).save(productArgumentCaptor.capture());

        Assert.assertEquals(addProductResponse.getResult().getProductId(), productArgumentCaptor.getValue().getId());
        Assert.assertEquals(addProductResponse.getResult().getSellerUsername(), productArgumentCaptor.getValue().getSellerUsername());
        Assert.assertEquals(addProductResponse.getResult().getCreatedDate(), productArgumentCaptor.getValue().getCreatedDate());
    }

    @Test(expected = ProductNotFoundException.class)
    public void Should_Catch_ProductNotFoundException_If_Product_Not_Found__When_Update_Product() {
        UpdateProductCommand updateProductCommand = fixture.create(UpdateProductCommand.class);

        when(productRepository.findProductByIdAndIsDeletedFalse(updateProductCommand.getId())).thenReturn(Optional.empty());

        try {
            productCommandHandler.update(updateProductCommand);
        } finally {
            verify(productRepository).findProductByIdAndIsDeletedFalse(updateProductCommand.getId());
        }
    }

    @Test
    public void Should_Update_Product_Successfully() {
        UpdateProductCommand updateProductCommand = fixture.create(UpdateProductCommand.class);
        Product product = new Product(fixture.create(AddProductCommand.class));

        when(productRepository.findProductByIdAndIsDeletedFalse(updateProductCommand.getId())).thenReturn(Optional.of(product));

        productCommandHandler.update(updateProductCommand);

        verify(productRepository).findProductByIdAndIsDeletedFalse(updateProductCommand.getId());
        verify(productRepository).save(product);
    }

    @Test(expected = ProductNotFoundException.class)
    public void Should_Catch_ProductNotFoundException_If_Product_Not_Found__When_Delete_Product() {
        DeleteProductCommand deleteProductCommand = fixture.create(DeleteProductCommand.class);

        when(productRepository.findProductByIdAndIsDeletedFalse(deleteProductCommand.getId())).thenReturn(Optional.empty());

        try {
            productCommandHandler.delete(deleteProductCommand);
        } finally {
            verify(productRepository).findProductByIdAndIsDeletedFalse(deleteProductCommand.getId());
        }
    }

    @Test
    public void Should_Delete_Product_Successfully() {
        DeleteProductCommand deleteProductCommand = fixture.create(DeleteProductCommand.class);
        Product product = new Product(fixture.create(AddProductCommand.class));

        when(productRepository.findProductByIdAndIsDeletedFalse(deleteProductCommand.getId())).thenReturn(Optional.of(product));

        productCommandHandler.delete(deleteProductCommand);

        verify(productRepository).findProductByIdAndIsDeletedFalse(deleteProductCommand.getId());
        verify(productRepository).save(product);
    }
}
