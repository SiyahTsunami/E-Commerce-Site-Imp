package com.dolap.backend.ecommercesite.domain.seller;

import com.dolap.backend.ecommercesite.domain.seller.command.AddSellerCommand;
import com.dolap.backend.ecommercesite.infrastructure.operations.DateOperations;
import org.axonframework.modelling.command.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AggregateRoot
public class Seller {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String phoneNumber;

    private String address;

    private String createdDate;

    private String changedDate;

    private boolean isDeleted;

    public Seller() {
    }

    public Seller(AddSellerCommand command) {
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.username = command.getUsername();
        this.password = command.getPassword();
        this.phoneNumber = command.getPhoneNumber();
        this.address = command.getAddress();
        this.createdDate = DateOperations.getNow();
        this.isDeleted = false;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
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
