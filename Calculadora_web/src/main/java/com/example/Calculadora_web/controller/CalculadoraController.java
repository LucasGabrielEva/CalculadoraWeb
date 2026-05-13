package com.example.Calculadora_web.controller;

import com.example.Calculadora_web.dto.CalculoRequest;
import com.example.Calculadora_web.model.Operacao;
import com.example.Calculadora_web.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalculadoraController {
    @Autowired
    private CalculadoraService service; // Injetando a nova camada Service

    @PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestBody CalculoRequest request) {
        try {
            if (request.getNumero1() == null || request.getOperador() == null) {
                return ResponseEntity.badRequest().body("Entrada inválida.");
            }

            // A lógica pesada foi toda para o Service!
            Operacao op = service.realizarCalculo(request.getNumero1(), request.getNumero2(), request.getOperador());

            return ResponseEntity.ok(op);

        } catch (ArithmeticException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro interno ao processar a operação.");
        }
    }

    @GetMapping("/historico")
    public List<Operacao> listarHistorico() {
        return service.listarHistorico();
    }

    @DeleteMapping("/historico")
    public ResponseEntity<?> limparHistorico() {
        service.limparHistorico();
        return ResponseEntity.ok("Histórico apagado com sucesso.");
    }
}
