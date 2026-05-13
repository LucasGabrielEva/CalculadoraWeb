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
	void contextLoads() {
	}

}
