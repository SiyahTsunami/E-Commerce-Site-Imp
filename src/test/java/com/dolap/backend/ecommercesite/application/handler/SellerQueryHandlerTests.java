package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.Seller;
import com.dolap.backend.ecommercesite.domain.seller.command.AddSellerCommand;
import com.dolap.backend.ecommercesite.domain.seller.exceptions.SellerNotFoundException;
import com.dolap.backend.ecommercesite.domain.seller.presentation.GetSellerResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.query.FindByUsernameQuery;
import com.dolap.backend.ecommercesite.infrastructure.repositories.SellerRepository;
import com.flextrade.jfixture.JFixture;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SellerQueryHandlerTests {

    @InjectMocks
    private SellerQueryHandler sellerQueryHandler;

    @Mock
    private SellerRepository sellerRepository;

    private JFixture fixture = new JFixture();

    @After
    public void after() {
        verifyNoMoreInteractions(sellerRepository);
    }

    @Test(expected = SellerNotFoundException.class)
    public void Should_Catch_SellerNotFoundException_If_Seller_Not_Found() {
        FindByUsernameQuery findByUsernameQuery = fixture.create(FindByUsernameQuery.class);

        when(sellerRepository.findSellerByUsernameAndIsDeletedFalse(findByUsernameQuery.getSellerId())).thenReturn(Optional.empty());

        try {
            sellerQueryHandler.query(findByUsernameQuery);
        } finally {
            verify(sellerRepository).findSellerByUsernameAndIsDeletedFalse(findByUsernameQuery.getSellerId());
        }
    }

    @Test
    public void Should_Get_Seller_Successfully() {
        FindByUsernameQuery findByUsernameQuery = fixture.create(FindByUsernameQuery.class);

        when(sellerRepository.findSellerByUsernameAndIsDeletedFalse(findByUsernameQuery.getSellerId())).thenReturn(Optional.of(new Seller()));


        sellerQueryHandler.query(findByUsernameQuery);

        verify(sellerRepository).findSellerByUsernameAndIsDeletedFalse(findByUsernameQuery.getSellerId());
    }
}
