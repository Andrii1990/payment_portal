package com.test.payment_portal.service;

import com.test.payment_portal.dto.ClientsDto;
import com.test.payment_portal.entity.Clients;
import org.springframework.stereotype.Component;

@Component
public class ClientsConverter {

    public Clients fromClientDtoToClient(ClientsDto clientsDto) {
        Clients clients = new Clients();
        clients.setFirstName(clientsDto.getFirstName());
        clients.setLastName(clientsDto.getLastName());
        return clients;
    }

    public ClientsDto fromClientToClientDto(Clients clients) {
        return ClientsDto.builder()
                .clientId(clients.getClientId())
                .firstName(clients.getFirstName())
                .lastName(clients.getLastName())
                .build();
    }
}
