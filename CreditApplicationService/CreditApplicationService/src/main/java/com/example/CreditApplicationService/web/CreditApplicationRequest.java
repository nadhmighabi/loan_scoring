package com.example.CreditApplicationService.web;

import lombok.Data;

import java.util.UUID;

@Data
public class CreditApplicationRequest {
    private UUID customerId;
    private Double amount;
    private Integer termInMonths;
    private String creditType;
}

