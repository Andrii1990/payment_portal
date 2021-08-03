package com.test.payment_portal.service;

import com.test.payment_portal.entity.Accounts;
import com.test.payment_portal.repository.AccountsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultAccountService implements AccountService {

    private final AccountsRepository accountsRepository;

    @Override
    public Accounts getEntityAccounts(final int id) {
        Accounts accounts = accountsRepository.findAccountsByClientId(id);
        if (accounts != null) {
            return accounts;
        }
        return null;
    }
}
