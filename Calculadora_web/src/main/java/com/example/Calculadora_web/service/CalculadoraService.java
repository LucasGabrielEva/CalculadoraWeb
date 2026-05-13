package com.example.Calculadora_web.service;

import com.example.Calculadora_web.model.Calculadora;
import com.example.Calculadora_web.model.Operacao;
import com.example.Calculadora_web.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculadoraService {
    @Autowired
    private Calculadora calculadora; // Sua classe com os métodos matemáticos

    @Autowired
    private OperacaoRepository repository;

    public Operacao realizarCalculo(Double n1, Double n2, String operador) {
        double resultado = 0;
        // Tratamento para a raiz quadrada (que só usa o n1)
        double num2 = (n2 != null) ? n2 : 0;

        // Delega o cálculo matemático para a classe Calculadora
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

        // Monta o objeto da operação
        Operacao op = new Operacao();
        op.setNumero1(n1);
        op.setNumero2(num2);
        op.setOperador(operador);
        op.setResultado(resultado);

        // Salva no banco de dados H2 e retorna
        return repository.save(op);
    }

    public List<Operacao> listarHistorico() {
        return repository.findAll();
    }

    public void limparHistorico() {
        repository.deleteAll();
    }
}
