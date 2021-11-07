package br.com.ex.stream;

public class Contato {
	
	private String nome;
	private String cidade;
	
	public Contato(String nome, String cidade) {
		this.nome = nome;	
		this.cidade = cidade;

		System.out.println("Criando um contato!!!");
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
}
