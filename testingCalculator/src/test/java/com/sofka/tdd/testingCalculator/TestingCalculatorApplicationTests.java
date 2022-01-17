package com.sofka.tdd.testingCalculator;

import com.sofka.tdd.testingCalculator.Calculadora.CalculadoraStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

		var cadena = new CalculadoraStrings("9,2");

		Assertions.assertEquals(cadena.stringCalculator(cadena.getCadena()), 11);
	}

}
