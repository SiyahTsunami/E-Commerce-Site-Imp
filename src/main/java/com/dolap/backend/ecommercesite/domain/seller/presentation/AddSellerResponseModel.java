package com.dolap.backend.ecommercesite.domain.seller.presentation;

import java.util.Objects;

public class AddSellerResponseModel {

    private String sellerId;

    private String username;

    private String createdDate;

    public AddSellerResponseModel() {
    }

    public AddSellerResponseModel(String sellerId, String username, String createdDate) {
        this.sellerId = sellerId;
        this.username = username;
        this.createdDate = createdDate;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        AddSellerResponseModel that = (AddSellerResponseModel) o;
        return Objects.equals(sellerId, that.sellerId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellerId, username, createdDate);
    }

    @Override
    public String toString() {
        return "AddSellerResponseModel{" +
                "sellerId='" + sellerId + '\'' +
                ", username='" + username + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

}
