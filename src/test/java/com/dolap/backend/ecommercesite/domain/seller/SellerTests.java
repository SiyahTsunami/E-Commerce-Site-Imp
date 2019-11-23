package com.dolap.backend.ecommercesite.domain.seller;

import com.dolap.backend.ecommercesite.domain.seller.command.AddSellerCommand;
import com.flextrade.jfixture.JFixture;
import org.junit.Assert;
import org.junit.Test;

public class SellerTests {

    private JFixture fixture = new JFixture();

    @Test
    public void Seller_Constructor_Test_For_AddSellerCommand() {
        AddSellerCommand addSellerCommand = fixture.create(AddSellerCommand.class);

        Seller seller = new Seller(addSellerCommand);

        Assert.assertNotNull(seller.getId());
        Assert.assertTrue(seller.getId().startsWith("Seller"));
        Assert.assertEquals(addSellerCommand.getFirstName(), seller.getFirstName());
        Assert.assertEquals(addSellerCommand.getLastName(), seller.getLastName());
        Assert.assertEquals(addSellerCommand.getUsername(), seller.getUsername());
        Assert.assertNotEquals(addSellerCommand.getPassword(), seller.getPassword());
        Assert.assertEquals(addSellerCommand.getPhoneNumber(), seller.getPhoneNumber());
        Assert.assertEquals(addSellerCommand.getAddress(), seller.getAddress());
        Assert.assertNotNull(seller.getCreatedDate());
        Assert.assertFalse(seller.isDeleted());
    }

}
