package com.dolap.backend.ecommercesite.domain.product;

import com.dolap.backend.ecommercesite.domain.constants.GenderTypeEnum;
import com.dolap.backend.ecommercesite.domain.product.command.AddProductCommand;
import com.dolap.backend.ecommercesite.domain.product.command.UpdateProductCommand;

import java.util.List;
import java.util.UUID;

public class Product {

    private String id;

    private String name;

    private String type;

    private String brand;

    private String unitPrice;

    private String unitWeight;

    private String description;

    private List<String> photoUrl;

    private GenderTypeEnum gender;

    private String createdBy;

    private String createdDate;

    private String updatedBy;

    private String updatedDate;

    private boolean isDeleted;

    public Product(AddProductCommand command) {
        this.id = UUID.randomUUID().toString();
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
        this.id = UUID.randomUUID().toString();
        this.name = command.getName();
        this.type = command.getType();
        this.brand = command.getBrand();
        this.unitPrice = command.getUnitPrice();
        this.unitWeight = command.getUnitWeight();
        this.description = command.getDescription();
        this.photoUrl = command.getPhotoUrl();
        this.gender = command.getGender();
    }

    public void delete() {
        this.isDeleted = true;
    }
}
