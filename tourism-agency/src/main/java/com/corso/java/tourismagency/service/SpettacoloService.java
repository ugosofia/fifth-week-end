package com.corso.java.tourismagency.service;

import com.corso.java.tourismagency.domain.Spettacolo;
import com.corso.java.tourismagency.repository.SpettacoloRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public interface SpettacoloService {


    Optional<Spettacolo> findById(String id);

    List<Spettacolo> findAll();



}
