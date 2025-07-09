package com.example.paiement.configuration;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class MetricsConfiguration implements HealthIndicator {
    @Bean
    public InfoContributor projectInfo() {
        return builder -> builder.withDetail("project", Map.of(
                "name", "Gestion_Sinistre",
                "version", "1.0.0",
                "status", "En cours de développement"
        ));
    }
    @Override
    public Health health() {
        return Health.up()
                .withDetail("app-check", "Application OK")
                .build();
    }

//
}
