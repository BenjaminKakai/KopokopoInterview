package com.kopo.transactionmanagement;

import com.kopo.transactionmanagement.model.Account;
import com.kopo.transactionmanagement.model.Transaction;
import com.kopo.transactionmanagement.service.AccountService;
import com.kopo.transactionmanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account();
        account.setBalance(1000);
        Account savedAccount = accountService.saveAccount(account); // Ensure saveAccount method exists and works

        Transaction transaction = new Transaction();
        transaction.setAccount(savedAccount);
        transaction.setAmount(100);
        transaction.setCreatedAt(LocalDateTime.now());
        transactionService.saveTransaction(transaction); // Ensure saveTransaction method exists and works
    }
}
