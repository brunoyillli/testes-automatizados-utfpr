package io.github.brunoyillli.validadorIdentifierAtividade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ProcessIdentifier {

	public static void main(String args[]) {
		String identificador = JOptionPane.showInputDialog(null, "Digite um identificador");
		isValidIdentifier(identificador);
		JOptionPane.showMessageDialog(null, "O identficador é valido");
	}

	public static Boolean isValidIdentifier(String identificador) {
		if (identificador.length() < 2 || identificador.length() > 6) {
			throw new IdentifierException("O identificador tem um tamanho invalido");
		}

		char firstChar = identificador.charAt(0);
		if (!Character.isLetter(firstChar)) {
			throw new IdentifierException("O primeiro caracter deve ser uma letra apenas");
		}

		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(identificador);
		if (!matcher.matches()) {
			throw new IdentifierException("A identficador deve conter apenas caracteres e numeros");
		}
		return true;
	}

}
