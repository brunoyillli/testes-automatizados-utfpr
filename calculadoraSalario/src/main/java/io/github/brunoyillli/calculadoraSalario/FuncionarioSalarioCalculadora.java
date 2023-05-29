package io.github.brunoyillli.calculadoraSalario;

import java.math.BigDecimal;

import io.github.brunoyillli.calculadoraSalario.entity.Funcionario;

public class FuncionarioSalarioCalculadora {
	private static final BigDecimal DESENVOLVEDOR_SALARIO_BASE_DESCONTO = BigDecimal.valueOf(3000);
	private static final BigDecimal DBA_SALARIO_BASE_DESCONTO = BigDecimal.valueOf(2000);
	private static final BigDecimal TESTADOR_SALARIO_BASE_DESCONTO = BigDecimal.valueOf(2000);
	private static final BigDecimal GERENTE_SALARIO_BASE_DESCONTO = BigDecimal.valueOf(5000);

	public BigDecimal calcularDescontoSalario(Funcionario funcionario) {
		BigDecimal salarioDescontado = BigDecimal.ZERO;
		switch (funcionario.getCargo()) {
		case DESENVOLVEDOR:
			salarioDescontado = calcularDescontoVinteOuDez(funcionario.getSalario(),
					DESENVOLVEDOR_SALARIO_BASE_DESCONTO);
			break;
		case DBA:
			salarioDescontado = calcularDescontoVinteCintoOuQuinze(funcionario.getSalario(), DBA_SALARIO_BASE_DESCONTO);
			break;
		case TESTADOR:
			salarioDescontado = calcularDescontoVinteCintoOuQuinze(funcionario.getSalario(),
					TESTADOR_SALARIO_BASE_DESCONTO);
			break;
		case GERENTE:
			salarioDescontado = calcularDescontoTrintaOuVinte(funcionario.getSalario(), GERENTE_SALARIO_BASE_DESCONTO);
			break;
		default:
			throw new IllegalArgumentException("Cargo invalido: " + funcionario.getCargo());
		}

		return salarioDescontado.setScale(1);
	}

	private BigDecimal calcularDescontoTrintaOuVinte(BigDecimal salario, BigDecimal descontoBase) {
		BigDecimal taxaDesconto = salario.compareTo(descontoBase) >= 0 ? BigDecimal.valueOf(0.30)
				: BigDecimal.valueOf(0.20);
		return salario.subtract(salario.multiply(taxaDesconto));
	}

	private BigDecimal calcularDescontoVinteCintoOuQuinze(BigDecimal salario, BigDecimal descontoBase) {
		BigDecimal taxaDesconto = salario.compareTo(descontoBase) >= 0 ? BigDecimal.valueOf(0.25)
				: BigDecimal.valueOf(0.15);
		return salario.subtract(salario.multiply(taxaDesconto));
	}

	private BigDecimal calcularDescontoVinteOuDez(BigDecimal salario, BigDecimal descontoBase) {
		BigDecimal taxaDesconto = salario.compareTo(descontoBase) >= 0 ? BigDecimal.valueOf(0.20)
				: BigDecimal.valueOf(0.10);
		return salario.subtract(salario.multiply(taxaDesconto));
	}

}
