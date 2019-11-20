package com.dolap.backend.ecommercesite.domain.product;

import com.dolap.backend.ecommercesite.domain.constants.GenderTypeEnum;
import com.dolap.backend.ecommercesite.domain.constants.ProductTypeEnum;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.UpdateProductCommand;
import com.dolap.backend.ecommercesite.infrastructure.operations.DateOperations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.axonframework.modelling.command.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
@AggregateRoot
public class Product {

    @Id
    private String id;

    private String name;

    private ProductTypeEnum type;

    private String description;

    private String content;

    private String brand;

    private double unitPrice;

    private double unitWeight;

    private String photoUrl;

    private GenderTypeEnum gender;

    private String sellerId;

    private String createdDate;

    private String changedDate;

    private boolean isDeleted;

    public Product() {
    }

    public Product(AddProductCommand command) {
        this.id = "Product_" + UUID.randomUUID().toString();
        this.name = command.getName();
        this.type = command.getType();
        this.description = command.getDescription();
        this.content = command.getContent();
        this.brand = command.getBrand();
        this.unitPrice = command.getUnitPrice();
        this.unitWeight = command.getUnitWeight();
        this.photoUrl = command.getPhotoUrl();
        this.gender = command.getGender();
        this.createdDate = DateOperations.getNow();
        this.isDeleted = false;
    }

    public void update(UpdateProductCommand command) {
        this.name = StringUtils.isBlank(command.getName()) ? this.name : command.getName();
        this.type = command.getType() == null ? this.type : command.getType();
        this.description = StringUtils.isBlank(command.getDescription()) ? this.description : command.getDescription();
        this.content = StringUtils.isBlank(command.getContent()) ? this.description : command.getDescription();
        this.brand = StringUtils.isBlank(command.getBrand()) ? this.brand : command.getBrand();
        this.unitPrice = ObjectUtils.isEmpty(command.getUnitPrice()) ? this.unitPrice : command.getUnitPrice();
        this.unitWeight = ObjectUtils.isEmpty(command.getUnitWeight()) ? this.unitWeight : command.getUnitWeight();
        this.photoUrl = StringUtils.isBlank(command.getPhotoUrl()) ? this.photoUrl : command.getPhotoUrl();
        this.gender = command.getGender() == null ? this.gender : command.getGender();
        this.changedDate = DateOperations.getNow();
    }

    public void delete() {
        this.changedDate = DateOperations.getNow();
        this.isDeleted = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductTypeEnum getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getBrand() {
        return brand;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getUnitWeight() {
        return unitWeight;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public GenderTypeEnum getGender() {
        return gender;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", brand='" + brand + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitWeight=" + unitWeight +
                ", photoUrl='" + photoUrl + '\'' +
                ", gender=" + gender +
                ", sellerId=" + sellerId +
                ", createdDate='" + createdDate + '\'' +
                ", changedDate='" + changedDate + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

}
