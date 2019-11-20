package com.dolap.backend.ecommercesite.domain.product.commands;

import com.dolap.backend.ecommercesite.domain.constants.GenderTypeEnum;
import com.dolap.backend.ecommercesite.domain.constants.ProductTypeEnum;
import com.dolap.backend.ecommercesite.interfaces.Command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class AddProductCommand implements Command {

    @NotBlank
    private String name;

    @NotNull
    private ProductTypeEnum type;

    @NotBlank
    private String description;

    @NotBlank
    private String content;

    @NotBlank
    private String brand;

    @NotBlank
    private double unitPrice;

    @NotBlank
    private double unitWeight;

    @NotBlank
    private String photoUrl;

    @NotNull
    private GenderTypeEnum gender;

    public AddProductCommand() {
    }

    public AddProductCommand(String name, ProductTypeEnum type, String description, String content, String brand, double unitPrice, double unitWeight, String photoUrl, GenderTypeEnum gender) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddProductCommand that = (AddProductCommand) o;
        return Objects.equals(name, that.name) &&
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
        return Objects.hash(name, type, description, content, brand, unitPrice, unitWeight, photoUrl, gender);
    }

    @Override
    public String toString() {
        return "AddProductCommand{" +
                "name='" + name + '\'' +
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
