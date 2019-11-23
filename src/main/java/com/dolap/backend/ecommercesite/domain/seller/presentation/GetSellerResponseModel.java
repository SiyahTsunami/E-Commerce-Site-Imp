package com.dolap.backend.ecommercesite.domain.seller.presentation;

import com.dolap.backend.ecommercesite.domain.seller.Seller;

import java.util.Objects;

public class GetSellerResponseModel {

    private String id;

    private String firstName;

    private String lastName;

    private String username;

    private String phoneNumber;

    private String address;

    private String createdDate;

    public GetSellerResponseModel() {
    }

    public GetSellerResponseModel(Seller seller) {
        this.id = seller.getId();
        this.firstName = seller.getFirstName();
        this.lastName = seller.getLastName();
        this.username = seller.getUsername();
        this.phoneNumber = seller.getPhoneNumber();
        this.address = seller.getAddress();
        this.createdDate = seller.getCreatedDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        GetSellerResponseModel that = (GetSellerResponseModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(username, that.username) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(address, that.address) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, phoneNumber, address, createdDate);
    }

    @Override
    public String toString() {
        return "GetSellerResponseModel{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

}
