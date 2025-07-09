package com.example.CreditApplicationService.web;

import lombok.Data;

@Data
public class StatusUpdateRequest {
    private String status;
    private String comment;
}

