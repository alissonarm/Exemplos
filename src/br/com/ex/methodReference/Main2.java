package br.com.ex.methodReference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


interface MinhaInterfaceFuncional {
	void ola();
}

public class Main2 {

	public static void main(String[] args) {

		Todo todo = new Todo("Gravar aula para o canal", 1);
		System.out.println(todo.getDescricao() + " => " + todo.isFeito());
		
		Consumer<Todo> consumidor = Todo::feito;
		consumidor.accept(todo);
		
		MinhaInterfaceFuncional minhaInterfaceFuncional = todo::feito;
		minhaInterfaceFuncional.ola();
		
		
		System.out.println(todo.getDescricao() + " => " + todo.isFeito());
		
		
	}

}
