package com.dolap.backend.ecommercesite.application.handler;

import com.dolap.backend.ecommercesite.domain.constants.ResponseModel;
import com.dolap.backend.ecommercesite.domain.seller.Seller;
import com.dolap.backend.ecommercesite.domain.seller.command.AddSellerCommand;
import com.dolap.backend.ecommercesite.domain.seller.exceptions.SellerAlreadyCreatedException;
import com.dolap.backend.ecommercesite.domain.seller.presentation.AddSellerResponseModel;
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

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SellerCommandHandlerTests {

    @InjectMocks
    private SellerCommandHandler sellerCommandHandler;

    @Mock
    private SellerRepository sellerRepository;

    private JFixture fixture = new JFixture();

    @Captor
    private ArgumentCaptor<Seller> sellerArgumentCaptor;

    @After
    public void after() {
        verifyNoMoreInteractions(sellerRepository);
    }

    @Test(expected = SellerAlreadyCreatedException.class)
    public void Should_Catch_SellerAlreadyCreatedException_If_Seller_Already_Created() {
        AddSellerCommand addSellerCommand = fixture.create(AddSellerCommand.class);

        when(sellerRepository.existsSellerByUsernameAndIsDeletedFalse(addSellerCommand.getUsername())).thenReturn(true);

        try {
            sellerCommandHandler.add(addSellerCommand);
        } finally {
            verify(sellerRepository).existsSellerByUsernameAndIsDeletedFalse(addSellerCommand.getUsername());
        }
    }

    @Test
    public void Should_Add_Seller_Successfully() {
        AddSellerCommand addSellerCommand = fixture.create(AddSellerCommand.class);

        when(sellerRepository.existsSellerByUsernameAndIsDeletedFalse(addSellerCommand.getUsername())).thenReturn(false);

        sellerCommandHandler.add(addSellerCommand);

        verify(sellerRepository).existsSellerByUsernameAndIsDeletedFalse(addSellerCommand.getUsername());
        verify(sellerRepository).save(sellerArgumentCaptor.capture());
    }
}