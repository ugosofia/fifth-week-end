package com.corso.java.tourismagency.ControllerTest;

import com.corso.java.tourismagency.controller.ClienteController;
import com.corso.java.tourismagency.controller.SpettacoloController;
import com.corso.java.tourismagency.domain.Cliente;
import com.corso.java.tourismagency.domain.Spettacolo;
import com.corso.java.tourismagency.service.ClienteService;
import com.corso.java.tourismagency.service.SpettacoloService;
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
public class SpettacoloTestController {


        @Mock
        SpettacoloService spettacoloService;

        @Autowired
        private MockMvc mockMvc;

        @Mock
        private Spettacolo spettacolo;

        private List<Spettacolo> spettacoloList;

        @InjectMocks
        private SpettacoloController spettacoloController;

        @BeforeEach
        public void setUp() {
            spettacolo = new Spettacolo();
            mockMvc = MockMvcBuilders.standaloneSetup(spettacoloController).build();

        }

        @AfterEach
        public void tearDown() {
            spettacolo = null;
        }


        public static String asJsonString(final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Test
        public void GetMappingOfAllShows() throws Exception {
            when(spettacoloService.findAllShows()).thenReturn(spettacoloList);
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/spettacoli/").contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(spettacolo))).andDo(MockMvcResultHandlers.print());
            verify(spettacoloService).findAllShows();
            verify(spettacoloService, times(1)).findAllShows();
        }

        @Test
        public void GetMappingOfShowByIdShouldReturnRespectiveshow() throws Exception {
            when(spettacoloService.findShowById(spettacolo.getId()))
                    .thenReturn(any());
            mockMvc.perform(get("/api/v2/get/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(spettacolo)))
                    .andExpect(MockMvcResultMatchers.status()
                            .isOk())
                    .andDo(MockMvcResultHandlers.print());

        }

        @Test
        public void PostMappingOfShow() throws Exception {
            when(spettacoloService.addShow(any())).thenReturn(any());
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/spettacolo/").contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(spettacolo))).andDo(MockMvcResultHandlers.print());
            verify(spettacoloService).addShow(any());
            verify(spettacoloService, times(1)).addShow(any());

        }
    }


