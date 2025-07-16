package com.example.CustomerService.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;
@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Customer(UUID id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}