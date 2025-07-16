package com.example.CustomerService.web;

import com.example.CustomerService.service.CustomerService;
import com.example.CustomerService.web.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public UUID createCustomer(@RequestBody CustomerDTO dto) {
        return customerService.save(dto);
    }
}
