package com.dolap.backend.ecommercesite.domain.product.commands;

import com.dolap.backend.ecommercesite.domain.constants.GenderTypeEnum;
import com.dolap.backend.ecommercesite.domain.constants.ProductTypeEnum;
import com.dolap.backend.ecommercesite.interfaces.Command;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class UpdateProductCommand implements Command {

    @JsonIgnore
    private long id;

    private String name;

    private ProductTypeEnum type;

    private String description;

    private String content;

    private String brand;

    private String unitPrice;

    private String unitWeight;

    private String photoUrl;

    private GenderTypeEnum gender;

    public UpdateProductCommand() {
    }

    public UpdateProductCommand(String name, ProductTypeEnum type, String description, String content, String brand, String unitPrice, String unitWeight, String photoUrl, GenderTypeEnum gender) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.content = content;
        this.brand = brand;
        this.unitPrice = unitPrice;
        this.unitWeight = unitWeight;
        this.photoUrl = photoUrl;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(String unitWeight) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateProductCommand that = (UpdateProductCommand) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                type == that.type &&
                Objects.equals(description, that.description) &&
                Objects.equals(content, that.content) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(unitWeight, that.unitWeight) &&
                Objects.equals(photoUrl, that.photoUrl) &&
                gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, description, content, brand, unitPrice, unitWeight, photoUrl, gender);
    }

    @Override
    public String toString() {
        return "UpdateProductCommand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", brand='" + brand + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", unitWeight='" + unitWeight + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", gender=" + gender +
                '}';
    }

}
