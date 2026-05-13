package com.example.Calculadora_web.repository;

import com.example.Calculadora_web.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoRepository extends JpaRepository<Operacao,Long> {
}
