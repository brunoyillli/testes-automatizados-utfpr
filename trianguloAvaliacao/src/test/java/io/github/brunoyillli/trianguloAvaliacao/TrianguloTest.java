package io.github.brunoyillli.trianguloAvaliacao;

import io.github.brunoyillli.trianguloAvaliacao.Triangulo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.brunoyillli.trianguloAvaliacao.TipoTriangulo;
import io.github.brunoyillli.trianguloAvaliacao.exception.TrianguloException;

public class TrianguloTest {

	private static final String messageExceptionTrianguloGeneric = "Os valores fornecidos não formam um triângulo válido";

	@Test
    public void isTrianguloEscalenoValidoTest() throws TrianguloException {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        Assertions.assertEquals(TipoTriangulo.ESCALENO, triangulo.getTipo());
    }

    @Test
    public void isTrianguloIsoscelesValidoTest() throws TrianguloException {
        Triangulo triangulo = new Triangulo(3, 3, 2);
        Assertions.assertEquals(TipoTriangulo.ISOSCELES, triangulo.getTipo());
    }

    @Test
    public void isTrianguloEquilateroValidoTest() throws TrianguloException {
        Triangulo triangulo = new Triangulo(3, 3, 3);
        Assertions.assertEquals(TipoTriangulo.EQUILATERO, triangulo.getTipo());
    }
    
    @Test
    public void isTrianguloIsoscelesPermutacoesTest() throws TrianguloException {
        Triangulo t1 = new Triangulo(3, 3, 2);
        Triangulo t2 = new Triangulo(3, 2, 3);
        Triangulo t3 = new Triangulo(2, 3, 3);
        Assertions.assertEquals(TipoTriangulo.ISOSCELES, t1.getTipo());
        Assertions.assertEquals(TipoTriangulo.ISOSCELES, t2.getTipo());
        Assertions.assertEquals(TipoTriangulo.ISOSCELES, t3.getTipo());
    }
    
    @Test
    public void isValorZeroTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(0, 1, 2);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    public void isValorNegativoTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(-1, 2, 3);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    public void isSomaDoisLadosIgualAoTerceiroPermutacao1Test() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(1, 2, 3);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isSomaDoisLadosIgualAoTerceiroPermutacao2Test() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(2, 3, 1);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isSomaDoisLadosIgualAoTerceiroPermutacao3Test() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(3, 1, 2);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isSomaDoisLadosMenorQueTerceiroPermutacao1Test() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(5, 1, 2);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isSomaDoisLadosMenorQueTerceiroPermutacao2Test() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(1, 5, 2);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isSomaDoisLadosMenorQueTerceiroPermutacao3Test() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(1, 2, 5);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isTodosLadosIguaisZeroTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(0, 0, 0);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    public void isDiferencaEntreAECIgualBTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(5, 2, 3);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isDiferencaEntreAEBIgualCTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(5, 3, 2);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    public void isAbsACMenorBTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(2, 6, 1);
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isBMenorACSomaTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(4, 7, 3); 
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isAbsABMenorCTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(3, 2, 7); 
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void isCMenorABSomaTest() {
        Exception exception = assertThrows(TrianguloException.class, () -> {
            new Triangulo(6, 3, 2); 
        });

        String expectedMessage = messageExceptionTrianguloGeneric;
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}
