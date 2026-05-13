package com.example.Calculadora_Web.model;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {
    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero não permitida");
        }
        return a / b;
    }

    public double porcentagem(double a, double b) { return a * (b / 100); }

    public double potencia(double a, double b) { return Math.pow(a, b); }

    public double raizQuadrada(double a) {
        if (a < 0) {
            throw new ArithmeticException("Erro: Raiz quadrada de número negativo não permitida");
        }
        return Math.sqrt(a);
    }
}
