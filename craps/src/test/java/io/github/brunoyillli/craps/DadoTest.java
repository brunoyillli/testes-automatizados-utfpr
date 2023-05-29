package io.github.brunoyillli.craps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.brunoyillli.craps.dominio.Dado;

public class DadoTest {
	
	@Test
	public void rolarDadoTest() {
        Dado dado = new Dado();
        int resultado = dado.rolar();

        Assertions.assertTrue(resultado >= 1 && resultado <= 6);
    }
}
