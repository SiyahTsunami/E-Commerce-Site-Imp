package com.dolap.backend.ecommercesite.infrastructure.repositories;


import com.dolap.backend.ecommercesite.domain.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCommandRespository extends CrudRepository<Product, Long> {
}
