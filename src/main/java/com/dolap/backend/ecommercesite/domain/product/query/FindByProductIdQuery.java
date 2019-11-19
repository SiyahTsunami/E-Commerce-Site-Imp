package com.dolap.backend.ecommercesite.domain.product.query;

import com.dolap.backend.ecommercesite.interfaces.Query;

import java.util.Objects;

public class FindByProductIdQuery implements Query {

    private long productId;

    public FindByProductIdQuery() {
    }

    public FindByProductIdQuery(long productId) {
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
        FindByProductIdQuery that = (FindByProductIdQuery) o;
        return productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "FindByProductIdQuery{" +
                "productId=" + productId +
                '}';
    }

}
