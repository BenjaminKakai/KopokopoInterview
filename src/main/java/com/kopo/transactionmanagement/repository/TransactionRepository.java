package com.kopo.transactionmanagement.repository;

import com.kopo.transactionmanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    // Custom methods can be defined here if required
}
