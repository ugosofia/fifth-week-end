package com.corso.java.tourismagency.service;

import com.corso.java.tourismagency.domain.Spettacolo;
import com.corso.java.tourismagency.repository.SpettacoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpettacoloServiceImpl implements SpettacoloService{

    @Autowired
    SpettacoloRepository spettacoloRepository;

    @Override
    public Optional<Spettacolo> findById(String id) {
        return spettacoloRepository.findById(id);
    }

    @Override
    public List<Spettacolo> findAll() {
        return spettacoloRepository.findAll();
    }
}


