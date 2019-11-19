package com.dolap.backend.ecommercesite.domain.product.commands;

import com.dolap.backend.ecommercesite.interfaces.Command;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class DeleteProductCommand implements Command {

    @JsonIgnore
    private long productId;

    public DeleteProductCommand() {
    }

    public DeleteProductCommand(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteProductCommand that = (DeleteProductCommand) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "DeleteProductCommand{" +
                "productId='" + productId + '\'' +
                '}';
    }

}
