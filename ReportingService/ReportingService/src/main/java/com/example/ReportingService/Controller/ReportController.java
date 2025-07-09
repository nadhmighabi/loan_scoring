package com.example.ReportingService.Controller;

import com.example.ReportingService.domain.Report;
import com.example.ReportingService.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportRepository reportRepository;

    @GetMapping
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable UUID id) {
        return reportRepository.findById(id).orElseThrow(() -> new RuntimeException("Report not found"));
    }
}

