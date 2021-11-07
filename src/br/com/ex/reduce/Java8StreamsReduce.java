package br.com.ex.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class Java8StreamsReduce {

	public static void main(String[] args) {
		
		String string = "Aprendendo Stream Reduce";
		String[] split = string.split(" ");
		List<String> list = Arrays.asList(split);
		
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> listaVazia = Arrays.asList();

		//reduce - soma 
		Optional<Integer> soma = lista.stream()
			.reduce((n1, n2) -> n1 + n2);
		
		System.out.println(soma.get());

		//reduce - multiplicação 
		Optional<Integer> multiplicacao = lista.stream()
			.reduce((n1, n2) -> n1 * n2);
		
		System.out.println(multiplicacao.get());

		//reduce - concatenação 
		Optional<String> concatenacao = list.stream()
			.reduce((s1, s2) -> s1.concat(s2));
		
		System.out.println(concatenacao.get());

		// ATENCAO - NAO USE SUBTRACAO COM REDUCE
		//reduce - subtração 
		Optional<Integer> subtracao = lista.stream()
			.reduce((n1, n2) -> n1 - n2);
		
		System.out.println(subtracao.get());
		
		//reduce - VALOR DE IDENTIDADE - soma 
		Integer soma2 = lista.stream()
			.reduce(0, (n1, n2) -> n1 + n2);
		
		//reduce - VALOR DE IDENTIDADE - soma 
		Integer soma3 = listaVazia.stream()
			.reduce(0, (n1, n2) -> n1 + n2);

		System.out.println(soma2);
		System.out.println(soma3);

		//reduce - VALOR DE IDENTIDADE - multiplicação 
		Integer multiplicacao2 = lista.stream()
			.reduce(1, (n1, n2) -> n1 * n2);
		
		System.out.println(multiplicacao2);

		//reduce - VALOR DE IDENTIDADE - concatenação 
		String concatenacao2 = list.stream()
			.reduce("", (s1, s2) -> s1.concat(s2));
		
		System.out.println(concatenacao2);
		
		//reduce - menor valor
		DoubleStream.of(1.5, 2.9, 6.7)
			.forEach(System.out::println);

		System.out.println(DoubleStream.of(1.5, 2.9, 6.7)
				.reduce((d1, d2) -> Math.min(d1, d2)));
		
		System.out.println(DoubleStream.of(1.5, 2.9, 6.7)
				.reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2)));

		//reduce - FUNCAO DE COMBINACAO - soma 
		Integer soma4 = lista.stream()
			.reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
		
		System.out.println(soma4);
		
		//reduce - FUNCAO DE COMBINACAO - map + combiner 
		Optional<String> reduce = lista.stream()
			.map(n1 -> n1.toString())
			.reduce((n1, n2) -> n1.concat(n2));
		
		System.out.println(reduce);
		

		String reduce2 = lista.stream()
				.reduce("", 
						(n1, n2) -> n1.toString().concat(n2.toString()), 
						(n1, n2) -> n1.concat(n2)); 
			
			System.out.println(reduce2);

		
//		//reduce - multiplicação 
//		Optional<Integer> multiplicacao = lista.stream()
//			.reduce((n1, n2) -> n1 * n2);
//		
//		System.out.println(multiplicacao.get());
//
//		//reduce - concatenação 
//		Optional<String> concatenacao = list.stream()
//			.reduce((s1, s2) -> s1.concat(s2));
//		
//		System.out.println(concatenacao.get())
		
		
	}
}
