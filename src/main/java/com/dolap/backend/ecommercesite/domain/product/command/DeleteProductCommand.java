package com.dolap.backend.ecommercesite.domain.product.command;

import com.dolap.backend.ecommercesite.contracts.interfaces.Command;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class DeleteProductCommand implements Command {

    @JsonIgnore
    private String id;

    public DeleteProductCommand() {
    }

    public DeleteProductCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteProductCommand that = (DeleteProductCommand) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DeleteProductCommand{" +
                "id=" + id +
                '}';
    }

}
