package com.example.RiskEvaluationService;

import com.example.RiskEvaluationService.web.CreditApplicationCreatedEvent;
import com.example.RiskEvaluationService.web.CreditRiskEvaluatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@SpringBootApplication
@Slf4j
public class RiskEvaluationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskEvaluationServiceApplication.class, args);
	}
	@Bean
	public Consumer<CreditApplicationCreatedEvent> creditApplicationCreated(StreamBridge streamBridge) {
		return event -> {
			log.info("📥 Reçu un événement : {} " , event); // <-- ajoute ceci
			String riskLevel = calculateRisk(event);
			CreditRiskEvaluatedEvent evaluatedEvent = new CreditRiskEvaluatedEvent(
					event.getApplicationId(),
					riskLevel,
					LocalDateTime.now()
			);
			streamBridge.send("creditRiskEvaluated-out-0", evaluatedEvent);
			log.info("📤 Envoyé à creditRiskEvaluated : {}" , evaluatedEvent);
		};
	}


	private String calculateRisk(CreditApplicationCreatedEvent event) {
		if (event.getAmount() > 50000) return "HIGH";
		if (event.getAmount() > 20000) return "MEDIUM";
		return "LOW";
	}
}
