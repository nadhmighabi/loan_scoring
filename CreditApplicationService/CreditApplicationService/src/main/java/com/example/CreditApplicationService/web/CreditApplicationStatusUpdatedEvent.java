package com.example.CreditApplicationService.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditApplicationStatusUpdatedEvent {
    private UUID applicationId;
    private String newStatus;
    private String comment;
    private LocalDateTime updatedAt;
}

