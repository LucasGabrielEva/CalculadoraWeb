package com.example.Calculadora_Web.controller;

import com.example.Calculadora_Web.dto.CalculoRequest;
import com.example.Calculadora_Web.model.Operacao;
import com.example.Calculadora_Web.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculadora")
@CrossOrigin(origins = "*")
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    @PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestBody CalculoRequest request) {
        try {
            if (request.getNumero1() == null || request.getOperador() == null) {
                return ResponseEntity.badRequest().body("Entrada inválida.");
            }


            Operacao opSalva = service.realizarCalculo(
                    request.getNumero1(),
                    request.getNumero2(),
                    request.getOperador()
            );

            return ResponseEntity.ok(opSalva);

        } catch (IllegalArgumentException | ArithmeticException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro interno na aplicação.");
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
