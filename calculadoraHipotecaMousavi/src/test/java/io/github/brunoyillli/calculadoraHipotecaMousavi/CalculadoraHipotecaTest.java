package io.github.brunoyillli.calculadoraHipotecaMousavi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.brunoyillli.calculadoraHipotecaMousavi.entity.Pessoa;

public class CalculadoraHipotecaTest {
	
	@Test
	void testCalcularHipotecaFemininoJovem() {
		Pessoa pessoa = new Pessoa();
		pessoa.setGenero(true);
		pessoa.setIdade(18);
		pessoa.setSalario(5000);
		assertEquals(350000, Principal.calcularHipoteca(pessoa), 0.01);
	}
	
	@Test
	void testCalcularHipotecaFemininoMedio() {
		Pessoa pessoa = new Pessoa();
		pessoa.setGenero(true);
		pessoa.setIdade(35);
		pessoa.setSalario(8000);
		assertEquals(400000, Principal.calcularHipoteca(pessoa), 0.01);
	}
	
	@Test
	void testCalcularHipotecaFemininoIdoso() {
		Pessoa pessoa = new Pessoa();
		pessoa.setGenero(true);
		pessoa.setIdade(50);
		pessoa.setSalario(10000);
		assertEquals(350000, Principal.calcularHipoteca(pessoa), 0.01);
	}
	
	@Test
	void testCalcularHipotecaMasculinoJovem() {
		Pessoa pessoa = new Pessoa();
		pessoa.setGenero(false);
		pessoa.setIdade(25);
		pessoa.setSalario(5000);
		assertEquals(375000, Principal.calcularHipoteca(pessoa), 0.01);
	}
	
	@Test
	void testCalcularHipotecaMasculinoMedio() {
		Pessoa pessoa = new Pessoa();
		pessoa.setGenero(false);
		pessoa.setIdade(40);
		pessoa.setSalario(8000);
		assertEquals(440000, Principal.calcularHipoteca(pessoa), 0.01);
	}
	
	@Test
	void testCalcularHipotecaMasculinoIdoso() {
		Pessoa pessoa = new Pessoa();
		pessoa.setGenero(false);
		pessoa.setIdade(55);
		pessoa.setSalario(10000);
		assertEquals(300000, Principal.calcularHipoteca(pessoa), 0.01);
	}
	
	@Test
	void testFatorMasculinoIdadeInvalida() {
		Pessoa pessoa = new Pessoa();
		pessoa.setGenero(false);
		pessoa.setIdade(17);
		pessoa.setSalario(5000);
		assertThrows(IllegalArgumentException.class, () -> {
			Principal.fatorMasculino(pessoa);
		});
	}
	
	@Test
	void testFatorFemininoIdadeInvalida() {
		Pessoa pessoa = new Pessoa();
		pessoa.setGenero(true);
		pessoa.setIdade(56);
		pessoa.setSalario(5000);
		assertThrows(IllegalArgumentException.class, () -> {
			Principal.fatorFeminino(pessoa);
		});
	}
}
