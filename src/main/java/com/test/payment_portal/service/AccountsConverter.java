package com.test.payment_portal.service;

import com.test.payment_portal.dto.AccountsDto;
import com.test.payment_portal.entity.Accounts;
import org.springframework.stereotype.Component;

@Component
public class AccountsConverter {

    public Accounts fromAccountDtoToAccount(AccountsDto accountsDto) {
            return Accounts.builder()
                    .accountNum(accountsDto.getNumber())
                    .type(accountsDto.getType())
                    .balance(accountsDto.getBalance())
                    .build();
    }

    public AccountsDto fromAccountToAccountDto(Accounts accounts) {
        return AccountsDto.builder()
                .balance(accounts.getBalance())
                .type(accounts.getType())
                .number(accounts.getAccountNum())
                .build();
    }
}
