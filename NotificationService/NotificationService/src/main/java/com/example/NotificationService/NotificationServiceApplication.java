package com.example.NotificationService;

import com.example.NotificationService.web.CreditRiskEvaluatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	public Consumer<CreditRiskEvaluatedEvent> creditRiskEvaluated() {
		return event -> {
			log.info("📬 Notification: Risk for application {} is evaluated as {} at {}" ,event.getApplicationId()
					 , event.getRiskLevel() , event.getEvaluatedAt());
		};
		//docker exec -it <kafka-container> kafka-console-consumer --bootstrap-server localhost:9092--topic creditApplicationCreated--from-beginning
	}





}
