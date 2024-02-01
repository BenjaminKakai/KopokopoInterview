package com.kopo.transactionmanagement.service;

import com.kopo.transactionmanagement.model.Account;
import com.kopo.transactionmanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(UUID id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElse(null);
    }

    public Account saveAccount(Account account) {
        // Here, you can include any pre-persistence validation or business logic
        return accountRepository.save(account);
    }

    // Additional business logic and methods can be added here
}
