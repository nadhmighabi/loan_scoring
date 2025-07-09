package com.example.paiement.domain.dto;

import com.example.paiement.domain.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommandDto {
    @NotEmpty(message = "La commande doit contenir au moins un produit.")
    @Valid
    @JsonProperty("products")
    private List<Product> products;
}
