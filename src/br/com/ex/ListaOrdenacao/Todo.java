package br.com.ex.ListaOrdenacao;

public class Todo {
	
	String descricao;
	int prioridade;
	
	public Todo(String descricao, int prioridade) {
		this.descricao = descricao;
		this.prioridade = prioridade;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	

}
