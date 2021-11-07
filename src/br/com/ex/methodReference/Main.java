package br.com.ex.methodReference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {

		List<Todo> todos = new ArrayList<Todo>();
		todos.add(new Todo("Gravar aula para o canal", 1));
		todos.add(new Todo("Arrumar a bicicleta", 20));
		todos.add(new Todo("Treinar corrida", 2));
		todos.add(new Todo("Estudar inglês", 3));
		todos.add(new Todo("Fazer Compras", 2));
		System.out.println(todos);	
		
		
		todos.forEach(t -> t.feito());
		
		Consumer<Todo> marcarComoFeito = Todo::feito;
		Consumer<Todo> marcarComoFeitoLambda = t -> t.feito();
		todos.forEach(Todo::feito); // method reference -> lambda -> Interface funcional
		
		todos.forEach(t -> System.out.println(t.getDescricao()));
		
		Comparator<Todo> comparaPelaDescricao = Comparator.comparing(Todo::getDescricao);
		todos.sort(comparaPelaDescricao);
		System.out.println(todos);
		
		Comparator<Todo> comparaPelaPrioridadeEDescricao = Comparator.comparing(Todo::getPrioridade).thenComparing(Todo::getDescricao);
		todos.sort(comparaPelaPrioridadeEDescricao);
		System.out.println(todos);
		
		
		
		
		
	}

}
