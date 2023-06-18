package io.github.brunoyillli.webconf2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NovaLinhaTest {
	
	@Test
	public void umCharTest() {
		NovaLinha novaLinha = new NovaLinha();
        Assertions.assertEquals("b", novaLinha.collapseNewlines("b"));
	}

	@Test
    public void variosCharENovasLinhasTest() {
        NovaLinha nl = new NovaLinha();
        Assertions.assertEquals("bruno\nmendes", nl.collapseNewlines("bruno\n\nmendes"));
    }
	
	@Test
    public void variosCharPoremNenhumaLinhaNovaTest() {
        NovaLinha nl = new NovaLinha();
        Assertions.assertEquals("brunomendes", nl.collapseNewlines("brunomendes"));
    }
}
