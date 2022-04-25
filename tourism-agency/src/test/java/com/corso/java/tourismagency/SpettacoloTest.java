package com.corso.java.tourismagency;

import com.corso.java.tourismagency.domain.Cliente;
import com.corso.java.tourismagency.domain.Spettacolo;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SpettacoloTest {
    @Mock
    Cliente cliente1;
    @Mock
    Spettacolo spettacolo;

    ArrayList<Cliente> list;

    @BeforeEach
    public void setUp() {
        cliente1 = new Cliente("Ugo", "3214443255");
        spettacolo = new Spettacolo(1);
        list = new ArrayList<>();
        spettacolo.setAttesa(list);
    }

    @AfterEach
    public void tearDown(){
        spettacolo = null;
        list = null;
    }

    @Test
    public void freeListTest() {
        assertTrue(spettacolo.libero());

        //spettacolo.prenota(cliente1.getNominativo(), cliente1.getTelNumber());
        //assertFalse(spettacolo.libero());
    }

    @Test
    public void searchClientTest() {
        list.add(cliente1);
        int res = spettacolo.trova(cliente1.getNominativo(), cliente1.getTelNumber());
        assertEquals(1, res);

        list.remove(cliente1);
        spettacolo.prenota(cliente1.getNominativo(), cliente1.getTelNumber());
        res = spettacolo.trova(cliente1.getNominativo(), cliente1.getTelNumber());
        assertEquals(0,res);

    }

    @Test
    public void deleteReservationTest() {
        spettacolo.prenota(cliente1.getNominativo(), cliente1.getTelNumber());
        assertFalse(spettacolo.libero());
        assertEquals(0, spettacolo.trova(cliente1.getNominativo(), cliente1.getTelNumber()));

        spettacolo.disdici(cliente1.getNominativo(), cliente1.getTelNumber());
        assertEquals(-1, spettacolo.trova(cliente1.getNominativo(), cliente1.getTelNumber()));
    }


}
