package br.com.ex.ListaOrdenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Main {
	
	public static void main(String[] args) {
	
		List<Todo> todos = new ArrayList<Todo>();
		todos.add(new Todo("Gravar aula para o canal", 1));
		todos.add(new Todo("Arrumar a bicicleta", 20));
		todos.add(new Todo("Estudar inglês", 3));
		System.out.println(todos);		

		List<String> nomes = new ArrayList<>();
		nomes.add("Ana");
		nomes.add("Pedro");
		nomes.add("Mario");
		System.out.println(nomes);
		
		// Atraves de classe anonima 
		Comparator<Todo> comparaPelaDescricao = new Comparator<Todo>() {
			@Override
			public int compare(Todo o1, Todo o2) {
				return o1.getDescricao().compareTo(o2.getDescricao());
			}
		};
       
		Collections.sort(todos, comparaPelaDescricao);
		System.out.println(todos);
		
		// Atraves de lambda 
		Comparator<Todo> comparaPelaDescricao2 = (o1, o2) -> o1.getDescricao().compareTo(o2.getDescricao());
       
		Collections.sort(todos, comparaPelaDescricao2);
		System.out.println(todos);

		todos.sort(comparaPelaDescricao2);
		System.out.println(todos);
		
		Comparator<Todo> comparaPelaDescricao3 = Comparator.comparing(t -> t.getDescricao());
		todos.sort(comparaPelaDescricao3);
		System.out.println(todos);
		
		Function<Todo, String> extraiDescricao = t -> t.getDescricao();
		Comparator<Todo> comparaPelaDescricao4 = Comparator.comparing(extraiDescricao);	
		todos.sort(comparaPelaDescricao4);
		System.out.println(todos);

		ToIntFunction<Todo> extraiPrioridade = t -> t.getPrioridade();
		Comparator<Todo> comparaPelaDescricao5 = Comparator.comparingInt(extraiPrioridade);	
		todos.sort(comparaPelaDescricao5);
		System.out.println(todos);

		nomes.sort((n1, n2) -> n1.compareTo(n2));
		System.out.println(nomes);
		
		nomes.sort(Comparator.naturalOrder());
		System.out.println(nomes);
	}
	
}
