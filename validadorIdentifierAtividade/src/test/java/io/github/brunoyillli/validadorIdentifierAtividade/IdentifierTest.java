package io.github.brunoyillli.validadorIdentifierAtividade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IdentifierTest {

	@Test
	public void deveReceberUmIdentifierValido() {
		Boolean validIdentifier = ProcessIdentifier.isValidIdentifier("ca12bc");
		assertTrue(validIdentifier);
	}
	
	@Test
	public void deveReceberUmIdentifierInvalidoMenorException() {
		
		IdentifierException exception = assertThrows(IdentifierException.class, () ->{
			ProcessIdentifier.isValidIdentifier("c");
		});
		
		String errorMessage = exception.getMessage();
		assertEquals("O identificador tem um tamanho invalido", errorMessage);
		
	}
	
	@Test
	public void deveReceberUmIdentifierInvalidoMaiorException() {
		
		IdentifierException exception = assertThrows(IdentifierException.class, () ->{
			ProcessIdentifier.isValidIdentifier("fbf48aa");
		});
		
		String errorMessage = exception.getMessage();
		assertEquals("O identificador tem um tamanho invalido", errorMessage);
		
	}
	
	@Test
	public void primeiroCaracterIdentifierNaoEhLetraException() {
		IdentifierException exception = assertThrows(IdentifierException.class, () -> {
			ProcessIdentifier.isValidIdentifier("1bvc");
		});
		String errorMessage = exception.getMessage();
		assertEquals("O primeiro caracter deve ser uma letra apenas", errorMessage);
	}
	
	@Test
	public void contemCaracaterDiferenteLetraOuNumeroException() {
		IdentifierException exception = assertThrows(IdentifierException.class, () -> {
			ProcessIdentifier.isValidIdentifier("bv1@cd");
		});
		String errorMessage = exception.getMessage();
		assertEquals("A identficador deve conter apenas caracteres e numeros", errorMessage);
	}
	
}
