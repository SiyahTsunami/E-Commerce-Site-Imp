package com.dolap.backend.ecommercesite.domain.product;

import com.dolap.backend.ecommercesite.domain.constants.GenderTypeEnum;
import com.dolap.backend.ecommercesite.domain.constants.ProductTypeEnum;
import com.dolap.backend.ecommercesite.domain.product.commands.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.commands.UpdateProductCommand;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.axonframework.modelling.command.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AggregateRoot
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private ProductTypeEnum type;

    private String description;

    private String content;

    private String brand;

    private String unitPrice;

    private String unitWeight;

    private String photoUrl;

    private GenderTypeEnum gender;

    private String sellerId;

    private String createdDate;

    private String changedDate;

    private boolean isDeleted;

    public Product() {
    }

    public Product(AddProductCommand command) {
        this.name = command.getName();
        this.type = command.getType();
        this.brand = command.getBrand();
        this.unitPrice = command.getUnitPrice();
        this.unitWeight = command.getUnitWeight();
        this.description = command.getDescription();
        this.photoUrl = command.getPhotoUrl();
        this.gender = command.getGender();
        this.isDeleted = false;
    }

    public void update(UpdateProductCommand command) {
        this.name = StringUtils.isBlank(command.getName()) ? this.name : command.getName();
        this.type = EnumUtils.isValidEnum(ProductTypeEnum.class, command.getType().name()) ? this.type : command.getType();
        this.brand = StringUtils.isBlank(command.getBrand()) ? this.brand : command.getBrand();
        this.unitPrice = StringUtils.isBlank(command.getUnitPrice()) ? this.unitPrice : command.getUnitPrice();
        this.unitWeight = StringUtils.isBlank(command.getUnitWeight()) ? this.unitWeight : command.getUnitWeight();
        this.description = StringUtils.isBlank(command.getDescription()) ? this.description : command.getDescription();
        this.photoUrl = StringUtils.isBlank(command.getPhotoUrl()) ? this.photoUrl : command.getPhotoUrl();
        this.gender = EnumUtils.isValidEnum(GenderTypeEnum.class, command.getGender().name()) ? this.gender : command.getGender();
    }

    public void delete() {
        this.isDeleted = true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductTypeEnum getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getUnitWeight() {
        return unitWeight;
    }

    public String getDescription() {
        return description;
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
}
