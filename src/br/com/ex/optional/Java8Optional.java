package br.com.ex.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;


// Observação o Optional é utilizado como retorno e não na assinatura.


public class Java8Optional {

	public static void main(String[] args) {
//		String s = "a";
		String s = "1";
		Optional<Integer> numero = converteEmNumero(s);

		System.out.println(numero.isPresent());   // retorna  true ou false
				
		numero.ifPresent(n -> System.out.println(n)); // so executa se a string for numerica
						
		converteEmNumero(s).ifPresent(n -> System.out.println(n)); // so executa se a string for numerica
		
		Integer numero2 = converteEmNumero(s).orElse(2);// tenta converter, se não conseguir devolve o valor no else
		System.out.println(numero2);
		
	
		Integer numero3 = converteEmNumero(s).orElseGet(() -> 5); // tenta converter, se não conseguir devolve o retorno na lambda
		System.out.println(numero3);
		
		//se nao conseguir converter, lança a exceção
		Integer numero4 = converteEmNumero(s).orElseThrow(() -> new NullPointerException("valor vazio")); 
		System.out.println(numero4);
		
		Stream.of(12, 13, 14).findFirst().ifPresent(System.out::println );
		
		converteEmNumeroPrimitivo(s).ifPresent(n -> System.out.println(n)); // so executa se a string for numerica
		
//		System.out.println(numero.get()); // se informar uma string, acontera uma exceção

		
		
		
		
		
	}
	
	public static Optional<Integer> converteEmNumero (String numeroStr) {
		
//		return Optional.ofNullable(null);
		
		try {
			return Optional.of(Integer.valueOf(numeroStr));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}
	
	public static OptionalInt converteEmNumeroPrimitivo (String numeroStr) {
		
		try {
			return OptionalInt.of(Integer.parseInt(numeroStr));
		} catch (NumberFormatException e) {
			return OptionalInt.empty();
		}
	}
	
}
