package com.example.paiement.client;

import com.example.paiement.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
public class ProductClientService {
    private final WebClient webClient;
    public ProductClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9098/api/product").build(); // URL du microservice produit
    }
    public List<Product> getAllProducts() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block(); // bloquant car on n'est pas en mode réactif pur
    }
}
