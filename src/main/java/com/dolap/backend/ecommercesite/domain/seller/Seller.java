package com.dolap.backend.ecommercesite.domain.seller;

import com.dolap.backend.ecommercesite.domain.seller.command.AddSellerCommand;
import com.dolap.backend.ecommercesite.infrastructure.operations.DateOperations;
import org.axonframework.modelling.command.AggregateRoot;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

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
        this.id = "Seller_" + UUID.randomUUID().toString();
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
        this.username = command.getUsername();
        this.password = encodeWithBCrypt(command.getPassword());
        this.phoneNumber = command.getPhoneNumber();
        this.address = command.getAddress();
        this.createdDate = DateOperations.getNow();
        this.isDeleted = false;
    }

    private String encodeWithBCrypt(String text) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(text);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", changedDate='" + changedDate + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }

}
