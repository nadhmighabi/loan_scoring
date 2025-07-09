package com.example.CreditApplicationService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditApplication {
    @Id
    @GeneratedValue
    @Getter
    private UUID id;
    private UUID customerId;
    private Double amount;
    private Integer termInMonths;
    private String creditType;
    private String status;
    private LocalDateTime submissionDate;
    private LocalDateTime lastUpdated;
    private String comment;
}
