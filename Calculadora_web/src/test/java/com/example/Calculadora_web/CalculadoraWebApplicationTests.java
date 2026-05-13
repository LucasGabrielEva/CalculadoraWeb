package com.example.Calculadora_web;

import com.example.Calculadora_web.service.CalculadoraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculadoraWebApplicationTests {
	@Autowired
	private CalculadoraService service;

	@BeforeEach
	void setUp() {
		service.limparHistorico();
	}

	@Test
	void deveSomarCorretamente() {

	}
	@Test
	void deveSubtrairCorretamente() {

	}
	@Test
	void deveMultiplicarCorretamente() {

	}

	@Test
	void deveDividirCorretamente() {

	}

	@Test
	void deveImpedirDivisaoPorZero() {

	}

	@Test
	void deveValidarEntrandaInvalidaOperador() {

	}

	@Test
	void devePermitirNumerosNegativos() {

	}

	@Test
	void devePermitirNumerosDecimais() {

	}

	@Test
	void deveCalcularPorcentagem() {

	}

	@Test
	void deveCalcularRaizQuadrada() {

	}

	@Test
	void deveImpedirRaizDeNumeroNegativo() {

	}

	@Test
	void deveSalvarNoHistorico() {

	}



}
