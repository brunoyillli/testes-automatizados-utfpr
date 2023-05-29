package io.github.brunoyillli.calculadoraHipotecaMousavi;

import javax.swing.JOptionPane;

import io.github.brunoyillli.calculadoraHipotecaMousavi.entity.Pessoa;

public class Principal {

	public static void main(String[] args) {
		Pessoa pessoa = receberPessoa();
		Double resultado = calcularHipoteca(pessoa);
		JOptionPane.showMessageDialog(null, "O resultado da hipoteca é : R$ " + resultado);
	}

	public static Double calcularHipoteca(Pessoa pessoa) {
		int fator = 0;
		if(pessoa.isGenero()) {
			fator = fatorFeminino(pessoa);
		}else {
			fator = fatorMasculino(pessoa);
		}
		double resultado = pessoa.getSalario() * fator;
		return resultado;
	}
	
	public static int fatorMasculino(Pessoa pessoa) {
		int fator = 0;
		if(pessoa.getIdade() >= 18 && pessoa.getIdade() <= 35 ) {
			fator = 75;
		} else if (pessoa.getIdade() >= 36 && pessoa.getIdade() <= 45) {
			fator = 55;
		}else if( pessoa.getIdade() >= 46 && pessoa.getIdade() <= 55) {
			fator = 30;
		}else {
			throw new IllegalArgumentException("Idade invalida para hipoteca");
		}
		return fator;
	}
	
	public static int fatorFeminino(Pessoa pessoa) {
		int fator = 0;
		if(pessoa.getIdade() >= 18 && pessoa.getIdade() <= 30 ) {
			fator = 70;
		} else if (pessoa.getIdade() >= 31 && pessoa.getIdade() <= 40) {
			fator = 50;
		}else if( pessoa.getIdade() >= 41 && pessoa.getIdade() <= 50) {
			fator = 35;
		}else {
			throw new IllegalArgumentException("Idade invalida para hipoteca");
		}
		return fator;
	}

	public static Pessoa receberPessoa() {
		Pessoa pessoa = new Pessoa();
		try {
			boolean genero = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Insira o genero"));
			int idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a idade"));
			int salario = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o salario"));
			pessoa.setGenero(genero);
			pessoa.setIdade(idade);
			pessoa.setSalario(salario);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Digite um valor numérico válido");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao receber os dados da pessoa");
		}
		return pessoa;
	}

}
