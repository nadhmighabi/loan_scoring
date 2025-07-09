package com.example.CreditApplicationService.web;

import com.example.CreditApplicationService.domain.CreditApplication;
import com.example.CreditApplicationService.service.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/credit-applications")
@RequiredArgsConstructor
class CreditApplicationController {

    private final CreditApplicationService creditApplicationService;

    @PostMapping
    public ResponseEntity<UUID> submit(@RequestBody CreditApplicationRequest request) {
        CreditApplication application = CreditApplication.builder()
                .customerId(request.getCustomerId())
                .amount(request.getAmount())
                .termInMonths(request.getTermInMonths())
                .creditType(request.getCreditType())
                .status("SUBMITTED")
                .submissionDate(LocalDateTime.now())
                .lastUpdated(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(creditApplicationService.save(application).getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditApplication> getById(@PathVariable UUID id) {
        return creditApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<CreditApplication> getByCustomer(@PathVariable UUID customerId) {
        return creditApplicationService.findByCustomerId(customerId);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Object> updateStatus(@PathVariable UUID id, @RequestBody StatusUpdateRequest req) {
        return creditApplicationService.findById(id).map(app -> {
            app.setStatus(req.getStatus());
            app.setLastUpdated(LocalDateTime.now());
            app.setComment(req.getComment());
            creditApplicationService.update(app);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
