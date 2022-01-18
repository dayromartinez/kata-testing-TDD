package com.sofka.tdd.testingCalculator;

import com.sofka.tdd.testingCalculator.Calculadora.CalculadoraStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TestingCalculatorApplicationTests {

	@Test
	@DisplayName("Cadena vacia")
	void cadenaVacia() {
		
		var cadena = new CalculadoraStrings();
		cadena.setCadena("");

		Assertions.assertEquals(cadena.stringCalculator(cadena.getCadena()), 0);
	}

	@Test
	@DisplayName("Un solo numero devuelve el valor")
	void devuelveValor(){

		var cadena = new CalculadoraStrings("2");
		var numero = Integer.parseInt(cadena.getCadena());

		Assertions.assertEquals(cadena.stringCalculator(cadena.getCadena()), numero);
	}

	@Test
	@DisplayName("Dos numeros, delimitados por coma, devuelven la suma.")
	void sumaPorComa(){

		var cadena = new CalculadoraStrings("11,11");

		Assertions.assertEquals(cadena.stringCalculator(cadena.getCadena()), 22);
	}

	@Test
	@DisplayName("Dos números, delimitados por saltos de línea, devuelve la suma.")
	void sumaPorSaltoLinea(){

		var cadena = new CalculadoraStrings("2\n9");

		Assertions.assertEquals(cadena.stringCalculator(cadena.getCadena()), 11);
	}

	@Test
	@DisplayName("Los números negativos arrojan una excepción")
	void numeroNegativo(){

		var cadena = new CalculadoraStrings("-11");

		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
				() -> cadena.stringCalculator(cadena.getCadena()),
				"Esperaba el método stringCalculator, pero no se encontró este método dentro de la clase"
		);

		assertTrue(thrown.getMessage().contains("Numero negativo"));
	}

	@Test
	@DisplayName("Los números superiores a 1000 se ignoran")
	void numeroMayorAMil(){

		var cadena = new CalculadoraStrings("1111");

		Assertions.assertEquals(cadena.stringCalculator(cadena.getCadena()),0);
	}

	@Test
	@DisplayName("Tres números, delimitados de cualquier manera, devuelven la suma")
	void sumaTresNumeros(){

		var cadena1 = new CalculadoraStrings("11 22 33");
		var cadena2 = new CalculadoraStrings("11,22,33");
		var cadena3 = new CalculadoraStrings("11#22#33");
		var cadena4 = new CalculadoraStrings("11\n22\n33");
		var cadena5 = new CalculadoraStrings("11/22/33");

		Assertions.assertEquals(cadena1.stringCalculator(cadena1.getCadena()), 66);
		Assertions.assertEquals(cadena2.stringCalculator(cadena2.getCadena()), 66);
		Assertions.assertEquals(cadena3.stringCalculator(cadena3.getCadena()), 66);
		Assertions.assertEquals(cadena4.stringCalculator(cadena4.getCadena()), 66);
		Assertions.assertEquals(cadena5.stringCalculator(cadena5.getCadena()), 66);
	}

}
