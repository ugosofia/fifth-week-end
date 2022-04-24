package com.corso.java.tourismagency.service;

import com.corso.java.tourismagency.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> findById(String id);

    List<Cliente> findAll();
}
