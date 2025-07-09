package com.example.paiement.service;

import com.example.paiement.domain.Command;
import com.example.paiement.domain.Product;
import com.example.paiement.domain.dto.CommandDto;
import com.example.paiement.repository.CommandRepo;
import com.example.paiement.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandServiceImp implements CommandService {
    private final CommandRepo commandRepo;
    @Autowired
    private ProductRepo productRepository;

    @Override
    @Transactional
    public Command addCommand(CommandDto commandDto) {
        List<Product> managedProducts = commandDto.getProducts().stream()
                .map(product -> productRepository.findById(product.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Produit introuvable : " + product.getId())))
                .toList();

        Command cmd = Command.builder()
                .products(managedProducts)
                .build();

        return commandRepo.save(cmd);
    }



}
