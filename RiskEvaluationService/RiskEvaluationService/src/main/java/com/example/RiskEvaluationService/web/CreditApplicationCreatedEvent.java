package com.example.RiskEvaluationService.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplicationCreatedEvent {
    private UUID applicationId;
    private UUID customerId;
    private Double amount;
    private Integer termInMonths;
    private String creditType;
}
