package com.example.paiement.repository;

import com.example.paiement.domain.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommandRepo extends JpaRepository<Command, Long> {
}
