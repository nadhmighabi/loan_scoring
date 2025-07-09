package com.example.ReportingService.service;

import com.example.ReportingService.domain.Report;
import com.example.ReportingService.repository.ReportRepository;
import com.example.ReportingService.web.CreditApplicationCreatedEvent;
import com.example.ReportingService.web.CreditRiskEvaluatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class ReportingHandler {
    private final ReportRepository reportRepository;
    private final Map<String, Report> tempStore = new HashMap<>();

    @Bean
    public Consumer<CreditApplicationCreatedEvent> creditApplicationCreated() {
        return event -> {
            Report report = new Report();
            report.setApplicationId(event.getApplicationId());
            report.setCustomerId(event.getCustomerId());
            report.setAmount(event.getAmount());
            report.setTermInMonths(event.getTermInMonths());
            report.setCreditType(event.getCreditType());
            tempStore.put(event.getApplicationId().toString(), report);
        };
    }

    @Bean
    public Consumer<CreditRiskEvaluatedEvent> creditRiskEvaluated() {
        return event -> {
            Report report = tempStore.getOrDefault(event.getApplicationId().toString(), new Report());
            report.setApplicationId(event.getApplicationId());
            report.setRiskLevel(event.getRiskLevel());
            report.setEvaluatedAt(event.getEvaluatedAt());
            reportRepository.save(report);
        };
    }
}
