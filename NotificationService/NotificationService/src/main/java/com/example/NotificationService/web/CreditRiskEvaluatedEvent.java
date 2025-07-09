package com.example.NotificationService.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditRiskEvaluatedEvent {
    private UUID applicationId;
    private String riskLevel;
    private LocalDateTime evaluatedAt;
}

