package br.com.ex.stream;

import java.util.List;

public class Pessoa {
	
	private String nome;
	private Integer idade;
	private double salario;
	private List<String> hobbies;
	
	public Pessoa(String nome, Integer idade, double salario, List<String> hobbies) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.hobbies = hobbies;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public double getSalario() {
		return salario;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	
}
