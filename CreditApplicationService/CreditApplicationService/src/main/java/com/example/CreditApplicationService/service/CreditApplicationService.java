package com.example.CreditApplicationService.service;

import com.example.CreditApplicationService.domain.CreditApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CreditApplicationService {

    CreditApplication save(CreditApplication application);

    Optional<CreditApplication> findById(UUID id);

    List<CreditApplication> findByCustomerId(UUID customerId);
    CreditApplication update(CreditApplication application);
}
