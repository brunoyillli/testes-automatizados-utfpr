package io.github.brunoyillli.calculadoraSalario.entity;

import java.math.BigDecimal;

public class Funcionario {

	private String nome;
	private String email;
	private BigDecimal salario;
	private CargoEnum cargo;

	public Funcionario(String nome, String email, BigDecimal salario, CargoEnum cargo) {
		this.nome = nome;
		this.email = email;
		this.salario = salario;
		this.cargo = cargo;
	}

	public Funcionario() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public CargoEnum getCargo() {
		return cargo;
	}

	public void setCargo(CargoEnum cargo) {
		this.cargo = cargo;
	}

}