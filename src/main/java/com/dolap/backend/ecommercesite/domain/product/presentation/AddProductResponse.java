package com.dolap.backend.ecommercesite.domain.product.presentation;

import java.util.Objects;

public class AddProductResponse {

    private AddProductResponseModel result;

    public AddProductResponse() {
    }

    public AddProductResponse(AddProductResponseModel result) {
        this.result = result;
    }

    public AddProductResponseModel getResult() {
        return result;
    }

    public void setResult(AddProductResponseModel result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddProductResponse that = (AddProductResponse) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "AddProductResponse{" +
                "result=" + result +
                '}';
    }
}
