package com.dolap.backend.ecommercesite.domain.constants;

import java.util.Objects;

public class ResponseModel<T> {

    private T result;

    public ResponseModel() {
    }

    public ResponseModel(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseModel<?> that = (ResponseModel<?>) o;
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
