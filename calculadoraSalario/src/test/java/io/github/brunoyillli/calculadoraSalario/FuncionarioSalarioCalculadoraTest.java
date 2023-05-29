package io.github.brunoyillli.calculadoraSalario;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.brunoyillli.calculadoraSalario.entity.CargoEnum;
import io.github.brunoyillli.calculadoraSalario.entity.Funcionario;

public class FuncionarioSalarioCalculadoraTest {

	@Test
	public void CalculandoDescontoMaiorDesenvolvedorTest() {
		FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
		Funcionario funcionario = new Funcionario("Bruno Mendes", "bruno@utfpr.com", BigDecimal.valueOf(12000),
				CargoEnum.DESENVOLVEDOR);
		BigDecimal salarioDescontadoExperado = BigDecimal.valueOf(9600.00);

		BigDecimal salarioDescontadoAtual = calculadora.calcularDescontoSalario(funcionario);

		Assertions.assertEquals(salarioDescontadoExperado, salarioDescontadoAtual);
	}

	@Test
	public void CalculandoDescontoMenorsDesenvolvedorTest() {
		FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
		Funcionario funcionario = new Funcionario("Uziel Sena", "uzi@utfpr.com", BigDecimal.valueOf(2000),
				CargoEnum.DESENVOLVEDOR);
		BigDecimal salarioDescontadoExperado = BigDecimal.valueOf(1800.00);

		BigDecimal salarioDescontadoAtual = calculadora.calcularDescontoSalario(funcionario);

		Assertions.assertEquals(salarioDescontadoExperado, salarioDescontadoAtual);
	}
	
	@Test
	public void CalculandoDescontoMaiorDBATest() {
		FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
		Funcionario funcionario = new Funcionario("Mayara", "mayara@utfpr.com", BigDecimal.valueOf(2000),
				CargoEnum.DBA);
		BigDecimal salarioDescontadoExperado = BigDecimal.valueOf(1500.00);

		BigDecimal salarioDescontadoAtual = calculadora.calcularDescontoSalario(funcionario);

		Assertions.assertEquals(salarioDescontadoExperado, salarioDescontadoAtual);
	}
	
	@Test
	public void testCalcularDescontoMaiorGerente() {
	    FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
	    Funcionario funcionario = new Funcionario("Ana Silva", "ana@example.com",
	            BigDecimal.valueOf(6000), CargoEnum.GERENTE);
	    BigDecimal salarioDescontadoEsperado = BigDecimal.valueOf(4200.0);

	    BigDecimal salarioDescontadoAtual = calculadora.calcularDescontoSalario(funcionario);

	    Assertions.assertEquals(salarioDescontadoEsperado, salarioDescontadoAtual);
	}

	@Test
	public void testCalcularDescontoMenorGerente() {
	    FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
	    Funcionario funcionario = new Funcionario("Carlos Oliveira", "carlos@example.com",
	            BigDecimal.valueOf(4000), CargoEnum.GERENTE);
	    BigDecimal salarioDescontadoEsperado = BigDecimal.valueOf(3200.0);

	    BigDecimal salarioDescontadoAtual = calculadora.calcularDescontoSalario(funcionario);

	    Assertions.assertEquals(salarioDescontadoEsperado, salarioDescontadoAtual);
	}

	@Test
	public void testCalcularDescontoMaiorTester() {
	    FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
	    Funcionario funcionario = new Funcionario("Julia Santos", "julia@example.com",
	            BigDecimal.valueOf(2500), CargoEnum.TESTADOR);
	    BigDecimal salarioDescontadoEsperado = BigDecimal.valueOf(1875.0);

	    BigDecimal salarioDescontadoAtual = calculadora.calcularDescontoSalario(funcionario);

	    Assertions.assertEquals(salarioDescontadoEsperado, salarioDescontadoAtual);
	}

	@Test
	public void testCalcularDescontoMenorTester() {
	    FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
	    Funcionario funcionario = new Funcionario("Pedro Alves", "pedro@example.com",
	            BigDecimal.valueOf(1500), CargoEnum.TESTADOR);
	    BigDecimal salarioDescontadoEsperado = BigDecimal.valueOf(1275.0);

	    BigDecimal salarioDescontadoAtual = calculadora.calcularDescontoSalario(funcionario);

	    Assertions.assertEquals(salarioDescontadoEsperado, salarioDescontadoAtual);
	}

	@Test
	public void testCalcularDescontoMenorDBA() {
	    FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
	    Funcionario funcionario = new Funcionario("Maria Oliveira", "maria@example.com",
	            BigDecimal.valueOf(1500), CargoEnum.DBA);
	    BigDecimal salarioDescontadoEsperado = BigDecimal.valueOf(1275.0);

	    BigDecimal salarioDescontadoAtual = calculadora.calcularDescontoSalario(funcionario);

	    Assertions.assertEquals(salarioDescontadoEsperado, salarioDescontadoAtual);
	}
	
	@Test
	public void calculandoDescontoCargoInvalidoExceptionTest() {
		
		 FuncionarioSalarioCalculadora calculadora = new FuncionarioSalarioCalculadora();
	        Funcionario funcionario = new Funcionario("João", "joao@example.com",
	                BigDecimal.valueOf(3000), CargoEnum.CARGO_INVALIDO);

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            calculadora.calcularDescontoSalario(funcionario);
	        });
		
	}
}
