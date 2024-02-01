package com.kopo.transactionmanagement.service;

import com.kopo.transactionmanagement.model.Transaction;
import com.kopo.transactionmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        // Before saving, you can add any business logic, such as validating the transaction amount
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(UUID id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.orElse(null);
    }

    public Transaction saveTransaction(Transaction transaction) {
        // Similar to createTransaction; consider if separate logic is needed for "create" vs "save/update"
        return transactionRepository.save(transaction);
    }

    // Additional business logic and methods can be added here
}
