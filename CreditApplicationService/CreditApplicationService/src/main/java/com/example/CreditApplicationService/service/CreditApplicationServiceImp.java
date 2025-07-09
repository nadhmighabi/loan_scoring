package com.example.CreditApplicationService.service;

import com.example.CreditApplicationService.domain.CreditApplication;
import com.example.CreditApplicationService.repository.CreditApplicationRepository;
import com.example.CreditApplicationService.web.CreditApplicationCreatedEvent;
import com.example.CreditApplicationService.web.CreditApplicationStatusUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreditApplicationServiceImp implements CreditApplicationService{
    private final CreditApplicationRepository creditApplicationRepository;
    private final StreamBridge streamBridge;

    @Override
    public CreditApplication save(CreditApplication application) {
        // D’abord on persiste l'entité (génération de l'ID)
        CreditApplication saved = creditApplicationRepository.save(application);

        // Ensuite on construit et envoie l’événement avec l'ID généré
        CreditApplicationCreatedEvent event = new CreditApplicationCreatedEvent(
                saved.getId(),
                saved.getCustomerId(),
                saved.getAmount(),
                saved.getTermInMonths(),
                saved.getCreditType()
        );
        streamBridge.send("creditApplicationCreated-out-0", event);
        System.out.println("📤 Event sent to Kafka: " + event);

        return saved;
    }


    @Override
    public Optional<CreditApplication> findById(UUID id) {
        return creditApplicationRepository.findById(id);
    }

    @Override
    public List<CreditApplication> findByCustomerId(UUID customerId) {
        return creditApplicationRepository.findByCustomerId(customerId);
    }

    @Override
    public CreditApplication update(CreditApplication application) {
        // Publier l’événement de mise à jour via StreamBridge
        CreditApplicationStatusUpdatedEvent event = new CreditApplicationStatusUpdatedEvent(
                application.getId(),
                application.getStatus(),
                application.getComment(),
                application.getLastUpdated()
        );
        streamBridge.send("creditApplicationStatusUpdated-out-0", event);
        return creditApplicationRepository.save(application);
    }
}
