package com.example.CustomerService.service;

import com.example.CustomerService.web.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    UUID save(CustomerDTO customerDTO);
}
