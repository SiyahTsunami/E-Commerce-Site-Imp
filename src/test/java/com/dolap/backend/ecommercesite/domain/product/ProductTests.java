package com.dolap.backend.ecommercesite.domain.product;


import com.dolap.backend.ecommercesite.domain.product.command.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.command.UpdateProductCommand;
import com.flextrade.jfixture.JFixture;
import org.junit.Assert;
import org.junit.Test;

public class ProductTests {

    private JFixture fixture = new JFixture();

    @Test
    public void Product_Constructor_Test_For_AddProductCommand() {
        AddProductCommand addProductCommand = fixture.create(AddProductCommand.class);

        Product product = new Product(addProductCommand);

        Assert.assertNotNull(product.getId());
        Assert.assertTrue(product.getId().startsWith("Product_"));
        Assert.assertEquals(addProductCommand.getName(), product.getName());
        Assert.assertEquals(addProductCommand.getCategory(), product.getCategory());
        Assert.assertEquals(addProductCommand.getDescription(), product.getDescription());
        Assert.assertEquals(addProductCommand.getContent(), product.getContent());
        Assert.assertEquals(addProductCommand.getBrand(), product.getBrand());
        Assert.assertEquals(addProductCommand.getUnitPrice(), product.getUnitPrice(), 0);
        Assert.assertEquals(addProductCommand.getUnitWeight(), product.getUnitWeight(), 0);
        Assert.assertEquals(addProductCommand.getPhotoUrl(), product.getPhotoUrl());
        Assert.assertEquals(addProductCommand.getGender(), product.getGender());
        Assert.assertEquals(addProductCommand.getSellerUsername(), product.getSellerUsername());
        Assert.assertNotNull(product.getCreatedDate());
        Assert.assertFalse(product.isDeleted());
    }

    @Test
    public void Product_Update_Test() {
        UpdateProductCommand updateProductCommand = fixture.create(UpdateProductCommand.class);
        Product product = new Product(fixture.create(AddProductCommand.class));

        product.update(updateProductCommand);

        Assert.assertEquals(updateProductCommand.getName(), product.getName());
        Assert.assertEquals(updateProductCommand.getCategory(), product.getCategory());
        Assert.assertEquals(updateProductCommand.getDescription(), product.getDescription());
        Assert.assertEquals(updateProductCommand.getContent(), product.getContent());
        Assert.assertEquals(updateProductCommand.getBrand(), product.getBrand());
        Assert.assertEquals(updateProductCommand.getUnitPrice(), product.getUnitPrice(), 0);
        Assert.assertEquals(updateProductCommand.getUnitWeight(), product.getUnitWeight(), 0);
        Assert.assertEquals(updateProductCommand.getPhotoUrl(), product.getPhotoUrl());
        Assert.assertEquals(updateProductCommand.getGender(), product.getGender());
        Assert.assertNotNull(product.getChangedDate());
    }

    @Test
    public void Product_Update_Test_For_UpdateProductCommand_Is_Clear() {
        UpdateProductCommand updateProductCommand = new UpdateProductCommand();
        AddProductCommand addProductCommand = fixture.create(AddProductCommand.class);
        Product product = new Product(addProductCommand);

        product.update(updateProductCommand);

        Assert.assertEquals(addProductCommand.getName(), product.getName());
        Assert.assertEquals(addProductCommand.getCategory(), product.getCategory());
        Assert.assertEquals(addProductCommand.getDescription(), product.getDescription());
        Assert.assertEquals(addProductCommand.getContent(), product.getContent());
        Assert.assertEquals(addProductCommand.getBrand(), product.getBrand());
        Assert.assertEquals(addProductCommand.getUnitPrice(), product.getUnitPrice(), 0);
        Assert.assertEquals(addProductCommand.getUnitWeight(), product.getUnitWeight(), 0);
        Assert.assertEquals(addProductCommand.getPhotoUrl(), product.getPhotoUrl());
        Assert.assertEquals(addProductCommand.getGender(), product.getGender());
        Assert.assertNotNull(product.getChangedDate());
    }

    @Test
    public void Product_Delete_Test() {
        Product product = new Product(fixture.create(AddProductCommand.class));

        product.delete();

        Assert.assertTrue(product.isDeleted());
    }

}
