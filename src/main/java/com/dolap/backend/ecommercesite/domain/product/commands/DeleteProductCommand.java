package com.dolap.backend.ecommercesite.domain.product.commands;

import com.dolap.backend.ecommercesite.interfaces.Command;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class DeleteProductCommand implements Command {

    @JsonIgnore
    private long id;

    public DeleteProductCommand() {
    }

    public DeleteProductCommand(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
