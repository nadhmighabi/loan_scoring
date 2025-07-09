package com.example.paiement.service;

import com.example.paiement.domain.Command;
import com.example.paiement.domain.Product;
import com.example.paiement.domain.dto.CommandDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface CommandService {
   Command addCommand(CommandDto commandDto);
}
