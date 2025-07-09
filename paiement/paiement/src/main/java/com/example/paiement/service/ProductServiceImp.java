package com.example.paiement.service;
import com.example.paiement.client.ProductClientService;
import com.example.paiement.domain.Product;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

   private final ProductClientService productClientService;

    /**
     * Récupère tous les produits enregistrés.
     *
     * @return une liste de produits
     */
    @Override
    public List<Product> getAllProducts() {
        return productClientService.getAllProducts();
    }
}

