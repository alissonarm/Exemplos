package br.com.ex.excecao;

public class Agenda {
	
	private String [] nomes = new String [10];
	private int contador = 0;
	
	public void adiciona(String contato) {
		nomes[contador] = contato;
		contador++;
	}
	
	public String[] getNomes() {
		return nomes;
	}
	

}
