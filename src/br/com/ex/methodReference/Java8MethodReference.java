package br.com.ex.methodReference;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Java8MethodReference {

	public static void main(String[] args) {
		
		List<Integer> lista = Arrays.asList(1, 2, 3 , 4 , 5 , 6 , 7);
		
		lista.stream().forEach(System.out::println); // com method reference
				
		lista.stream().forEach((n) -> System.out.println(n)); // sem method reference
		
        // Com métodos estáticos
		lista.stream()
		.map((n) -> multipliquePorDois(n))
		.forEach(System.out::println); 

		lista.stream()
		.map(Java8MethodReference::multipliquePorDois)
		.forEach(System.out::println);
		
		//construtores
		lista.stream()
		.map((n) -> new BigDecimal(n))
		.forEach(System.out::println); 
		
		lista.stream()
		.map(BigDecimal::new)
		.forEach(System.out::println); 
		
		//várias instancias
		lista.stream()
		.map((n) -> n.doubleValue())
		.forEach(System.out::println); 
		
		lista.stream()
		.map(Integer::doubleValue)
		.forEach(System.out::println); 
		
		//única instancia
		BigDecimal dois = new BigDecimal(3);
		lista.stream()
		.map(BigDecimal::new)
		.map((b) -> b.multiply(b))
		.forEach(System.out::println); 
		
		lista.stream()
		.map(BigDecimal::new)
		.map(dois::multiply)
		.forEach(System.out::println); 

		
		
	}
	
	private static Integer multipliquePorDois(Integer i) {
		return i*2;
	}
}
