package com.kopo.transactionmanagement.service;

import com.kopo.transactionmanagement.model.Account;
import com.kopo.transactionmanagement.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllAccountsTest() {
        // Setup our mock repository
        Account account1 = new Account();
        account1.setId(UUID.randomUUID());
        account1.setBalance(100);

        Account account2 = new Account();
        account2.setId(UUID.randomUUID());
        account2.setBalance(200);

        when(accountRepository.findAll()).thenReturn(Arrays.asList(account1, account2));

        // Execute the service call
        List<Account> returnedAccounts = accountService.getAllAccounts();

        // Assert the response
        assertNotNull(returnedAccounts, "The returned list should not be null");
        assertEquals(2, returnedAccounts.size(), "The size of returned accounts should be 2");
        verify(accountRepository, times(1)).findAll();
    }

    // Additional tests can be added here
}
