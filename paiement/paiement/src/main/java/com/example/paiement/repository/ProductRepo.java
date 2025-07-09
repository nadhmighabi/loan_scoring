package com.example.paiement.repository;

import com.example.paiement.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    boolean existsByName(String name);

}
