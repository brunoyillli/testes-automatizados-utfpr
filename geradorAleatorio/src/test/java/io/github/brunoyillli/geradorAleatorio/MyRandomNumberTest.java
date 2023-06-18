package io.github.brunoyillli.geradorAleatorio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MyRandomNumberTest {

	@Mock
	Random mockRandom;

	MyRandomNumber myRandomNumber;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		myRandomNumber = new MyRandomNumber(mockRandom);
	}

	@Test
	void gerarUmNumeroAletorioComSucesso() throws IntervaloInvalidoException {
		Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(5);
		int nextRandomNumber = myRandomNumber.nextRandomNumber(1, 10);
		Assertions.assertEquals(7, nextRandomNumber);
	}

	@Test
	void gerarUmNumeroAleatorioApoisRepeticaoComSucesso() throws IntervaloInvalidoException {
		Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(5, 5, 6);
		int firstRandomNumber = myRandomNumber.nextRandomNumber(1, 10);
		int secondRandomNumber = myRandomNumber.nextRandomNumber(1, 10);
		Assertions.assertNotEquals(firstRandomNumber, secondRandomNumber);
	}

	@Test
	void beginEhMaiorQueEndIntervaloInvalidoException() {
		assertThrows(IntervaloInvalidoException.class, () -> {
			myRandomNumber.nextRandomNumber(1, 0);
		});
	}

	@Test
	void beginEhMenorQueZeroIntervaloInvalidoException() {
		assertThrows(IntervaloInvalidoException.class, () -> {
			myRandomNumber.nextRandomNumber(-2, 8);
		});
	}

	@Test
	void endEhMenorQueZeroIntervaloInvalidoException() {
		assertThrows(IntervaloInvalidoException.class, () -> {
			myRandomNumber.nextRandomNumber(5, -6);
		});
	}

	@RepeatedTest(1000)
	void gerandoNumerosEntre0A100ComSucesso() throws IntervaloInvalidoException {
		MyRandomNumber myRandomNumberNoMock = new MyRandomNumber();
		int nextRandomNumber = myRandomNumberNoMock.nextRandomNumber(1, 100);
		Assertions.assertTrue(nextRandomNumber >= 1);
		Assertions.assertTrue(nextRandomNumber <= 99);
	}

}
