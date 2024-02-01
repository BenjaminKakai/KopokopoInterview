package com.kopo.transactionmanagement.repository;

import com.kopo.transactionmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    // Custom methods can be defined here if required
}
