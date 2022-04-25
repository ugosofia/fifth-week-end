package com.corso.java.tourismagency.controller;

import com.corso.java.tourismagency.domain.Cliente;
import com.corso.java.tourismagency.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("clienti")
    public ResponseEntity<List<Cliente>> findAllClients() {

        return new ResponseEntity<List<Cliente>>(
                (List<Cliente>) clienteService.findAllClients(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable("id") String id) {
        return new ResponseEntity(clienteService.findClientById(id), HttpStatus.OK);
    }

    @PostMapping("cliente")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente saveCliente = clienteService.addCliente(cliente);
        return new ResponseEntity(saveCliente, HttpStatus.CREATED);
    }
}
