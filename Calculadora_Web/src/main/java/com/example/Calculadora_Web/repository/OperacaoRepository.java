package com.example.Calculadora_Web.repository;

import com.example.Calculadora_Web.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoRepository extends JpaRepository<Operacao, Integer> {
}
