package br.com.ex.methodReference;

public class Todo {
	
	String descricao;
	int prioridade;
	boolean feito;
	
	public Todo(String descricao, int prioridade) {
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.feito = false;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}
	
	public boolean isFeito() {
		return feito;
	}

	public void feito() {
		this.feito = true;
	}

	@Override
	public String toString() {
		return descricao;
	}
	

}
