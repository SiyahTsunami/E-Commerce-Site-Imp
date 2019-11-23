package com.dolap.backend.ecommercesite.domain.product.presentation;

import com.dolap.backend.ecommercesite.domain.product.Product;

import java.util.Objects;

public class AddProductResponseModel {

    private String productId;

    private String sellerUsername;

    private String createdDate;

    public AddProductResponseModel() {
    }

    public AddProductResponseModel(Product product) {
        this.productId = product.getId();
        this.sellerUsername = product.getSellerUsername();
        this.createdDate = product.getCreatedDate();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddProductResponseModel that = (AddProductResponseModel) o;
        return productId == that.productId &&
                sellerUsername == that.sellerUsername &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, sellerUsername, createdDate);
    }

    @Override
    public String toString() {
        return "AddProductResponseModel{" +
                "productId=" + productId +
                ", sellerUsername=" + sellerUsername +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

}
