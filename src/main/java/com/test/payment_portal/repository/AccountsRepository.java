package com.test.payment_portal.repository;

import com.test.payment_portal.entity.Accounts;
import com.test.payment_portal.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    Accounts findAccountsByClientId(int clientId);
}
