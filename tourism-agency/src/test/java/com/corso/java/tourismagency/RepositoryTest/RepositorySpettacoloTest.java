package com.corso.java.tourismagency.RepositoryTest;

import com.corso.java.tourismagency.domain.Spettacolo;
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
public class RepositorySpettacoloTest {


        @Autowired
        SpettacoloRepository spettacoloRepository;
        Spettacolo spettacolo;

        @BeforeEach
        public void setUp() {
            spettacolo = new Spettacolo();
        }

        @AfterEach
        public void tearDown() {
            spettacoloRepository.deleteAll();
            spettacolo = null;
        }

        @Test
        public void givenShowToAddShouldReturnAddedShow()
        {
            spettacoloRepository.save(spettacolo);
            Spettacolo fetchedShow = spettacoloRepository.findById(spettacolo.getId()).get();
            assertEquals(1,fetchedShow.getId());
        }

        @Test
        public void GivenGetAllShows() {
            Spettacolo spettacolo1 = new Spettacolo();

            spettacoloRepository.save(spettacolo1);


            List<Spettacolo> spettacoloList = (List<Spettacolo>) spettacoloRepository.findAll();
            assertNotNull(spettacoloList.get(0).getId());
        }

        @Test
        public void givenIdTODeleteThenShouldDeleteTheShow() {

            spettacoloRepository.deleteById(spettacolo.getId());
            Spettacolo fetchedShow = spettacoloRepository.findById(spettacolo.getId()).get();
            assertNull(fetchedShow);
        }

    }
