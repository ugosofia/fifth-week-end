package com.corso.java.tourismagency.repository;

import com.corso.java.tourismagency.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
