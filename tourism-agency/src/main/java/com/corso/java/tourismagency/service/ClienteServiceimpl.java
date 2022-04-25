package com.corso.java.tourismagency.service;

import com.corso.java.tourismagency.domain.Cliente;
import com.corso.java.tourismagency.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceimpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> findClientById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findAllClients() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente addCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }
}
