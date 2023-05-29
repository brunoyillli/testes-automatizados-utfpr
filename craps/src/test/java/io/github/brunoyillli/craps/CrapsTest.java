package io.github.brunoyillli.craps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.github.brunoyillli.craps.dominio.Dado;

public class CrapsTest {

	private Dado dadoMock;
	private Craps craps;
	
	@BeforeEach
	public void setUp() {
		dadoMock = Mockito.mock(Dado.class);
		craps = new Craps();
		craps.setDado(dadoMock);

	}
	
	@Test
	public void jogadorGanhaPrimeiraRolagemTest() {
		Mockito.when(dadoMock.rolar()).thenReturn(4,3);
		craps.setDado(dadoMock);
		craps.rolarDados();
		Assertions.assertTrue(craps.isFimDeJogo());
		Assertions.assertEquals(1, craps.getVencedor());
	}
	
	@Test
	public void jogadorGanhaPrimeiraRolagemSegundaPossibilidadeTest() {
		Mockito.when(dadoMock.rolar()).thenReturn(5,6);
		
		craps.rolarDados();
		Assertions.assertTrue(craps.isFimDeJogo());
		Assertions.assertEquals(1, craps.getVencedor());
	}
	
	@Test
	public void bancaGanhaPrimeiraRolagemTest() {
		Mockito.when(dadoMock.rolar()).thenReturn(1,1);
		
		craps.rolarDados();
		Assertions.assertTrue(craps.isFimDeJogo());
		Assertions.assertEquals(2, craps.getVencedor());
	}
	
	@Test
	public void bancaGanhaPrimeiraRolagemSegundaPossibilidadeTest() {
		Mockito.when(dadoMock.rolar()).thenReturn(1,2);
		
		craps.rolarDados();
		Assertions.assertTrue(craps.isFimDeJogo());
		Assertions.assertEquals(2, craps.getVencedor());
	}
	
	@Test
	public void bancaGanhaPrimeiraRolagemTerceiraPossibilidadeTest() {
		Mockito.when(dadoMock.rolar()).thenReturn(6,6);
		
		craps.rolarDados();
		Assertions.assertTrue(craps.isFimDeJogo());
		Assertions.assertEquals(2, craps.getVencedor());
	}
	
	@Test
	public void jogadorGanhaSegundaRodadaTest() {
		Mockito.when(dadoMock.rolar()).thenReturn(3,3);
		craps.rolarDados();
		assertFalse(craps.isFimDeJogo());
		
		Mockito.when(dadoMock.rolar()).thenReturn(4,2);
		craps.rolarDados();
		assertTrue(craps.isFimDeJogo());
		assertEquals(1, craps.getVencedor());
	}
	
	@Test
	public void bancaGanhaQuartaRodadaTest() {
		Mockito.when(dadoMock.rolar()).thenReturn(4,4);
		craps.rolarDados();
		assertFalse(craps.isFimDeJogo());
	
		Mockito.when(dadoMock.rolar()).thenReturn(2,2);
		craps.rolarDados();
		assertFalse(craps.isFimDeJogo());
		
		Mockito.when(dadoMock.rolar()).thenReturn(6,3);
		craps.rolarDados();
		assertFalse(craps.isFimDeJogo());
		
		Mockito.when(dadoMock.rolar()).thenReturn(6,1);
		craps.rolarDados();
		assertTrue(craps.isFimDeJogo());
		assertEquals(2, craps.getVencedor());
		
	}
	
	
}
