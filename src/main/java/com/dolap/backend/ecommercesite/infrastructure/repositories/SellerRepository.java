package com.dolap.backend.ecommercesite.infrastructure.repositories;

import com.dolap.backend.ecommercesite.domain.seller.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends CrudRepository<Seller, String> {

    Optional<Seller> findSellerById(String id);
}
