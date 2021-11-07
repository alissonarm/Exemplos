package br.com.ex.stream;

import java.math.BigDecimal;

public class Funcionario {
	
	private String nome;
	private Integer idade;
	private BigDecimal salario;
	
	public Funcionario(String nome, Integer idade, BigDecimal salario) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

	
}
