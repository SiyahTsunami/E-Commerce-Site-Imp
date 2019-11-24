package com.dolap.backend.ecommercesite.domain.seller.query;

import com.dolap.backend.ecommercesite.contracts.interfaces.Query;

import java.util.Objects;

public class FindByUsernameQuery implements Query {

    private String sellerId;

    public FindByUsernameQuery() {
    }

    public FindByUsernameQuery(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindByUsernameQuery that = (FindByUsernameQuery) o;
        return Objects.equals(sellerId, that.sellerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellerId);
    }

    @Override
    public String toString() {
        return "FindBySellerIdQuery{" +
                "sellerId='" + sellerId + '\'' +
                '}';
    }

}
