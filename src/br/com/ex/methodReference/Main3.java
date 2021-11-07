package br.com.ex.methodReference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class Main3 {

	public static void main(String[] args) {

//		Supplier<Contato> fabricaDeContato = Contato::new;
//		Contato contato = fabricaDeContato.get();

		Function<String, Contato> fabricaDeContato = Contato::new;
		Contato contato = fabricaDeContato.apply("Roberto");
		System.out.println(contato.getNome());
		
		BiFunction<String, Integer,Todo> fabricaDeTodo = Todo::new;
		Todo todo = fabricaDeTodo.apply("Testes", 10);
		System.out.println(todo.getDescricao());
		
		

		
	}

}
