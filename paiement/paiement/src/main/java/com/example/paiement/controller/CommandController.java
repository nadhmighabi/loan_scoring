package com.example.paiement.controller;
import com.example.paiement.domain.Command;
import com.example.paiement.domain.Product;
import com.example.paiement.domain.dto.CommandDto;
import com.example.paiement.service.CommandService;
import com.example.paiement.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/command")
@RequiredArgsConstructor
public class CommandController {
    private final CommandService commandService;
    @PostMapping()
    @Operation(summary = "Effectuer une commande", description = "Effectue une commande")
    public ResponseEntity<Command> addCommand(@RequestBody CommandDto commandDto)
    {
        return new ResponseEntity<>(commandService.addCommand(commandDto), HttpStatus.OK);
    }
}
