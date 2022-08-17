package com.github.joferbr.clientes.model.repository;

import com.github.joferbr.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository <Servico, Integer> {
}
