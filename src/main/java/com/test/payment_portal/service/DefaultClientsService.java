package com.test.payment_portal.service;

import com.test.payment_portal.dto.AccountsDto;
import com.test.payment_portal.dto.ClientsDto;
import com.test.payment_portal.entity.Accounts;
import com.test.payment_portal.entity.Clients;
import com.test.payment_portal.exception.ValidationException;
import com.test.payment_portal.repository.ClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
@Transactional
public class DefaultClientsService implements ClientsService {

    private final ClientsRepository clientsRepository;
    private final ClientsConverter clientsConverter;


    @Override
    public ClientsDto saveClient(ClientsDto clientsDto) throws ValidationException {
        validateClientDto(clientsDto);
        final Clients clients = clientsConverter.fromClientDtoToClient(clientsDto);
        clientsDto.getAccounts()
                .forEach(account -> {
                    final Accounts accounts = Accounts.builder()
                            .accountNum(account.getNumber())
                            .type(account.getType())
                            .balance(account.getBalance())
                            .build();

                    clients.addAccount(accounts);
                });
        Clients savedClient = clientsRepository.save(clients);

        return clientsConverter.fromClientToClientDto(savedClient);
    }


    private void validateClientDto(ClientsDto clientsDto) throws ValidationException {
        if (isNull(clientsDto)) {
            throw new ValidationException("Object client is null");
        }

    }

    @Override
    public ClientsDto findByClientID(Integer clientId) {
        Clients clients = clientsRepository.findByClientId(clientId);
        if (clients != null) {
            return clientsConverter.fromClientToClientDto(clients);
        }
        return null;
    }

}
