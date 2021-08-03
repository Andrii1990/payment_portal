package com.test.payment_portal.controller;

import com.test.payment_portal.dto.ClientsDto;
import com.test.payment_portal.exception.ValidationException;
import com.test.payment_portal.service.ClientsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/clients")
@AllArgsConstructor
@Log
@CrossOrigin
public class ClientsController {

    private final ClientsService clientsService;

    @PostMapping(value = "/save",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ClientsDto saveClients(@RequestBody ClientsDto clientsDto) throws ValidationException {
        log.info("Handling save client ID: " + clientsDto);
        return clientsService.saveClient(clientsDto);
    }

    @GetMapping(value = "/findById",
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
    )
    public ClientsDto findByClientID(@RequestParam Integer clientId) {
        log.info("Handling find by client ID request: " + clientId);
        return clientsService.findByClientID(clientId);
    }


}
