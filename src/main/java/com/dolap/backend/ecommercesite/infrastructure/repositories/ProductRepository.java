package com.dolap.backend.ecommercesite.infrastructure.repositories;


import com.dolap.backend.ecommercesite.domain.product.Product;
import com.dolap.backend.ecommercesite.domain.product.constants.ProductCategoryEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

    Optional<Product> findProductByIdAndIsDeletedFalse(String id);

    Page<Product> findProductsByCategoryAndIsDeletedFalse(ProductCategoryEnum category, Pageable pageable);

    Boolean existsProductByNameAndSellerUsernameAndIsDeletedFalse(String productName, String sellerUsername);

}
