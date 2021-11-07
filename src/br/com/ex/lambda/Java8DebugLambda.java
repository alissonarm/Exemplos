package br.com.ex.lambda;

import java.util.Arrays;
import java.util.List;

public class Java8DebugLambda {

	public static void main(String[] args) {
		
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		lista.stream()
		.map((n) -> new StringBuilder().append(n).append("s").append("a"))
		.forEach(System.out::println);

		lista.stream()
		.peek(n -> System.out.println(n + "teste"))
		.map((n) -> new StringBuilder().append(n).append("s").append("a"))
		.forEach(System.out::println);
		
		
	}
}
