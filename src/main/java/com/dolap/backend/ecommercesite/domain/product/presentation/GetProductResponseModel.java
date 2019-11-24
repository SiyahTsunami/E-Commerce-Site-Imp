package com.dolap.backend.ecommercesite.domain.product.presentation;

import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.constants.GenderTypeEnum;
import com.dolap.backend.ecommercesite.domain.product.constants.ProductCategoryEnum;

import java.util.Objects;

public class GetProductResponseModel {

    private String name;

    private ProductCategoryEnum category;

    private String description;

    private String content;

    private String brand;

    private double unitPrice;

    private double unitWeight;

    private String photoUrl;

    private GenderTypeEnum gender;

    private String sellerUsername;

    private String createdDate;

    public GetProductResponseModel() {
    }

    public GetProductResponseModel(Product product) {
        this.name = product.getName();
        this.category = product.getCategory();
        this.description = product.getDescription();
        this.content = product.getContent();
        this.brand = product.getBrand();
        this.unitPrice = product.getUnitPrice();
        this.unitWeight = product.getUnitWeight();
        this.photoUrl = product.getPhotoUrl();
        this.gender = product.getGender();
        this.sellerUsername = product.getSellerUsername();
        this.createdDate = product.getCreatedDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(double unitWeight) {
        this.unitWeight = unitWeight;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public GenderTypeEnum getGender() {
        return gender;
    }

    public void setGender(GenderTypeEnum gender) {
        this.gender = gender;
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
        GetProductResponseModel that = (GetProductResponseModel) o;
        return Double.compare(that.unitPrice, unitPrice) == 0 &&
                Double.compare(that.unitWeight, unitWeight) == 0 &&
                Objects.equals(name, that.name) &&
                category == that.category &&
                Objects.equals(description, that.description) &&
                Objects.equals(content, that.content) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(photoUrl, that.photoUrl) &&
                gender == that.gender &&
                Objects.equals(sellerUsername, that.sellerUsername) &&
                Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, description, content, brand, unitPrice, unitWeight, photoUrl, gender, sellerUsername, createdDate);
    }

    @Override
    public String toString() {
        return "GetProductResponseModel{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", brand='" + brand + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitWeight=" + unitWeight +
                ", photoUrl='" + photoUrl + '\'' +
                ", gender=" + gender +
                ", sellerUsername='" + sellerUsername + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

}
