package com.corso.java.tourismagency.ControllerTest;

import com.corso.java.tourismagency.controller.ClienteController;
import com.corso.java.tourismagency.domain.Cliente;
import com.corso.java.tourismagency.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@RestController
public class ControllerClienteTest {

    @Mock
    ClienteService clienteService;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private Cliente cliente;

    private List<Cliente> listaclienti;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente("Ugo", "3290654431");
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();

    }

    @AfterEach
    public void tearDown() {
        cliente = null;
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void GetMappingOfAllClient() throws Exception {
        when(clienteService.findAllClients()).thenReturn(listaclienti);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/clienti/").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(cliente))).andDo(MockMvcResultHandlers.print());
        verify(clienteService).findAllClients();
        verify(clienteService, times(1)).findAllClients();
    }

    @Test
    public void GetMappingOfClientByIdShouldReturnRespectiveClient() throws Exception {
        when(clienteService.findClientById(cliente.getId()))
                .thenReturn(any());
        mockMvc.perform(get("/api/v2/get/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(cliente)))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void PostMappingOfClient() throws Exception {
        when(clienteService.addCliente(any())).thenReturn(any());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/cliente/").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(cliente))).andDo(MockMvcResultHandlers.print());
        verify(clienteService).addCliente(any());
        verify(clienteService, times(1)).addCliente(any());

    }
}

