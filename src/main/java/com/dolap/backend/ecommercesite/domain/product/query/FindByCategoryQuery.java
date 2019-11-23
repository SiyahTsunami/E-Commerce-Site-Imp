package com.dolap.backend.ecommercesite.domain.product.query;

import com.dolap.backend.ecommercesite.domain.constants.ProductCategoryEnum;

import java.util.Objects;


public class FindByCategoryQuery {

    private ProductCategoryEnum category;

    private int pageNo;

    private int pageSize;

    public FindByCategoryQuery() {
    }

    public FindByCategoryQuery(ProductCategoryEnum category, int pageNo, int pageSize) {
        this.category = category;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public ProductCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEnum category) {
        this.category = category;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindByCategoryQuery query = (FindByCategoryQuery) o;
        return pageNo == query.pageNo &&
                pageSize == query.pageSize &&
                category == query.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, pageNo, pageSize);
    }

    @Override
    public String toString() {
        return "FindByCategoryQuery{" +
                "category=" + category +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

}
