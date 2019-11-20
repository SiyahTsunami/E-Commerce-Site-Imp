package com.dolap.backend.ecommercesite.infrastructure.repositories;

import com.dolap.backend.ecommercesite.domain.seller.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, String> {
}
