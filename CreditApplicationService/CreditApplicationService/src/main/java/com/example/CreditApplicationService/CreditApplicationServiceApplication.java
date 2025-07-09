package com.example.CreditApplicationService;

import com.example.CreditApplicationService.repository.CreditApplicationRepository;
import com.example.CreditApplicationService.web.CreditRiskEvaluatedEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class CreditApplicationServiceApplication {
	@Bean
	public Consumer<CreditRiskEvaluatedEvent> creditRiskEvaluated(CreditApplicationRepository repository) {
		return event -> {
			repository.findById(event.getApplicationId()).ifPresent(application -> {
				application.setStatus("RISK_" + event.getRiskLevel());
				repository.save(application);
				System.out.println("✅ Status updated for " + event.getApplicationId() + " to RISK_" + event.getRiskLevel());
			});
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(CreditApplicationServiceApplication.class, args);
	}

}
