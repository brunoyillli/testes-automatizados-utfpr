package io.github.brunoyillli.trianguloAvaliacao;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o lado do lado A"));
		int b = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o lado do lado B"));
		int c = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o lado do lado C"));

		try {
			Triangulo triangulo = new Triangulo(a, b, c);
			JOptionPane.showMessageDialog(null, "O triângulo é " + triangulo.getTipo().name());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
