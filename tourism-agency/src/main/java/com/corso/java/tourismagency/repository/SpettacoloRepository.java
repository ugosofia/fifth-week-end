package com.corso.java.tourismagency.repository;

import com.corso.java.tourismagency.domain.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpettacoloRepository extends JpaRepository<Spettacolo, String> {
}
