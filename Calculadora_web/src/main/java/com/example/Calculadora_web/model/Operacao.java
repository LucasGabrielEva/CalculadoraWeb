package com.example.Calculadora_web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Operacao {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private Long id;
         private Double numero1;
         private Double numero2;
         private String operador;
         private Double resultado;

    public Operacao() {
    }

    public Operacao(Long id, Double numero1, Double numero2, String operador, Double resultado) {
        this.id = id;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operador = operador;
        this.resultado = resultado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}
