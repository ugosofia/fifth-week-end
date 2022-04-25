package com.corso.java.tourismagency.RepositoryTest;

import com.corso.java.tourismagency.domain.Cliente;
import com.corso.java.tourismagency.domain.Spettacolo;
import com.corso.java.tourismagency.repository.ClienteRepository;
import com.corso.java.tourismagency.repository.SpettacoloRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryClienteTest {



        @Autowired
        ClienteRepository clienteRepository;
        Cliente cliente;

        @BeforeEach
        public void setUp() {
            cliente = new Cliente("Ugo", "3452238874");
        }

        @AfterEach
        public void tearDown() {
            clienteRepository.deleteAll();
            cliente = null;
        }

        @Test
        public void givenShowToAddShouldReturnAddedClient()
        {
            clienteRepository.save(cliente);
            Cliente fetchedClient = clienteRepository.findById(cliente.getId()).get();
            assertEquals(1,fetchedClient.getId());
        }

        @Test
        public void GivenGetAllClients() {
           Cliente cliente1 = new Cliente("Andrea", "3290443125");
           Cliente cliente2 = new Cliente("Anna", "3452096651");

            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);


            List<Cliente> clienteList = (List<Cliente>) clienteRepository.findAll();
            assertEquals("Andrea", clienteList.get(0).getNominativo());
            assertEquals("Anna", clienteList.get(1).getNominativo());
        }

        @Test
        public void givenIdTODeleteThenShouldDeleteTheClient() {

            clienteRepository.deleteById(cliente.getId());
            Cliente fetchedClient = clienteRepository.findById(cliente.getId()).get();
            assertNull(fetchedClient);
        }

    }


