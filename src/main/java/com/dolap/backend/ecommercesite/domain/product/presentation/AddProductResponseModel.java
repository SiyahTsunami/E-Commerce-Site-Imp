package com.dolap.backend.ecommercesite.domain.product.presentation;

import java.util.Objects;

public class AddProductResponseModel {

    private long productId;

    private long sellerId;

    private String createdDate;

    public AddProductResponseModel() {
    }

    public AddProductResponseModel(long productId, long sellerId, String createdDate) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.createdDate = createdDate;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
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
