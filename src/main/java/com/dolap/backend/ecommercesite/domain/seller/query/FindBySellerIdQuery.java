package com.dolap.backend.ecommercesite.domain.seller.query;

import com.dolap.backend.ecommercesite.interfaces.Query;

import java.util.Objects;

public class FindBySellerIdQuery implements Query {

    private String sellerId;

    public FindBySellerIdQuery() {
    }

    public FindBySellerIdQuery(String sellerId) {
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
        FindBySellerIdQuery that = (FindBySellerIdQuery) o;
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
