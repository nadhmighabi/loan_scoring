package com.example.paiement.controller;


import com.example.paiement.domain.Command;
import com.example.paiement.domain.Product;
import com.example.paiement.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    @Operation(summary = "Liste des produits", description = "Retourne tous les produits enregistrés")
    public List<Product> getProducts()
    {
        return productService.getAllProducts();
    }


}
