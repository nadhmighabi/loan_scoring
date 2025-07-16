package com.example.CustomerService.service;

import com.example.CustomerService.domain.Customer;
import com.example.CustomerService.repository.CustomerRepository;
import com.example.CustomerService.web.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public UUID save(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .id(UUID.randomUUID())
                .firstName(customerDTO.firstName())
                .lastName(customerDTO.lastName())
                .email(customerDTO.email())
                .phoneNumber(customerDTO.phoneNumber())
                .build();

        customerRepository.save(customer);
        return customer.getId();
    }
}
