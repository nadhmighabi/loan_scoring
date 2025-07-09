package com.example.CreditApplicationService.repository;


import com.example.CreditApplicationService.domain.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication, UUID> {
    List<CreditApplication> findByCustomerId(UUID customerId);
}
