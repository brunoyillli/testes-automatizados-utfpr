package io.github.brunoyillli.trianguloAvaliacao;

import io.github.brunoyillli.trianguloAvaliacao.exception.TrianguloException;

public class Triangulo {
	
	private int a;
	private int b;
	private int c;
	private TipoTriangulo tipo;

	public Triangulo(int a, int b, int c) throws TrianguloException {
		this.a = a;
		this.b = b;
		this.c = c;
		if (!validaTriangulo()) {
			throw new TrianguloException("Os valores fornecidos não formam um triângulo válido");
		}
		tipo = tipoTriangulo();
	}
    
	private boolean validaTriangulo() {
	    return validaDiferencaBCA() && validaSomaBCA() && 
	           validaDiferencaACB() && validaSomaACB() && 
	           validaDiferencaABC() && validaSomaABC();
	}

	public boolean validaDiferencaBCA() {
	    return Math.abs(b - c) < a;
	}

	public boolean validaSomaBCA() {
	    return a < b + c;
	}

	public boolean validaDiferencaACB() {
	    return Math.abs(a - c) < b;
	}

	public boolean validaSomaACB() {
	    return b < a + c;
	}

	public boolean validaDiferencaABC() {
	    return Math.abs(a - b) < c;
	}

	public boolean validaSomaABC() {
	    return c < a + b;
	}
    
	private TipoTriangulo tipoTriangulo() {
		if (a == b && b == c) {
			return TipoTriangulo.EQUILATERO;
		} else if (a != b && b != c && c != a) {
			return TipoTriangulo.ESCALENO;
		} else {
			return TipoTriangulo.ISOSCELES;
		}
	}

	public TipoTriangulo getTipo() {
		return tipo;
	}
	
}
