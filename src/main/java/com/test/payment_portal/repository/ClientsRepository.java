package com.test.payment_portal.repository;

import com.test.payment_portal.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {

    Clients findByClientId(Integer clientId);
}
