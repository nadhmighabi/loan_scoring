package com.example.ReportingService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor

public class Report {
    @Id
    private UUID applicationId;
    private UUID customerId;
    private Double amount;
    private Integer termInMonths;
    private String creditType;
    private String riskLevel;
    private LocalDateTime evaluatedAt;
}
