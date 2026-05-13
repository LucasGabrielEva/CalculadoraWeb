package com.example.Calculadora_Web.service;

import com.example.Calculadora_Web.model.Calculadora;
import com.example.Calculadora_Web.model.Operacao;
import com.example.Calculadora_Web.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculadoraService {
    @Autowired
    private Calculadora calculadora;

    @Autowired
    private OperacaoRepository repository;

    public Operacao realizarCalculo(Double n1, Double n2, String operador) {
        double resultado = 0;
        double num2 = (n2 != null) ? n2 : 0;

        switch (operador) {
            case "+": resultado = calculadora.somar(n1, num2); break;
            case "-": resultado = calculadora.subtrair(n1, num2); break;
            case "*": resultado = calculadora.multiplicar(n1, num2); break;
            case "/": resultado = calculadora.dividir(n1, num2); break;
            case "%": resultado = calculadora.porcentagem(n1, num2); break;
            case "^": resultado = calculadora.potencia(n1, num2); break;
            case "sqrt": resultado = calculadora.raizQuadrada(n1); break;
            default: throw new IllegalArgumentException("Operador inválido.");
        }

        Operacao op = new Operacao();
        op.setNumero1(n1);
        op.setNumero2(num2);
        op.setOperador(operador);
        op.setResultado(resultado);

        return repository.save(op);
    }

    public List<Operacao> listarHistorico() {
        return repository.findAll();
    }

    public void limparHistorico() {
        repository.deleteAll();
    }
}
