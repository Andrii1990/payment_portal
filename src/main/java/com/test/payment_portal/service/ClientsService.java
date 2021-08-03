package com.test.payment_portal.service;

import com.test.payment_portal.dto.ClientsDto;
import com.test.payment_portal.exception.ValidationException;

import java.util.List;

public interface ClientsService {

    ClientsDto saveClient(ClientsDto clientsDto) throws ValidationException;

    ClientsDto findByClientID(Integer clientId);

}
