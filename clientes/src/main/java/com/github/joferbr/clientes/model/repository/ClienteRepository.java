package com.github.joferbr.clientes.model.repository;

import com.github.joferbr.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>{
}
