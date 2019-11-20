package com.dolap.backend.ecommercesite.domain.product.presentation;

import java.util.Objects;

public class AddProductResponseModel {

    private String productId;

    private String sellerId;

    private String createdDate;

    public AddProductResponseModel() {
    }

    public AddProductResponseModel(String productId, String sellerId, String createdDate) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.createdDate = createdDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
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
                sellerId == that.sellerId &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, sellerId, createdDate);
    }

    @Override
    public String toString() {
        return "AddProductResponseModel{" +
                "productId=" + productId +
                ", sellerId=" + sellerId +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

}
