package br.com.ex.optional;

public class Contato {
	
	private String nome;
	
	public Contato(String nome) {
		this.nome = nome;	

		System.out.println("Criando um contato!!!");
	}

	public String getNome() {
		return nome;
	}

	
}
