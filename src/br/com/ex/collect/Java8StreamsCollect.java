package br.com.ex.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Java8StreamsCollect {

	public static void main(String[] args) {

		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6);

		// fornecedor - acumulação - combinação
		ArrayList<Object> collect = lista.stream()
				.collect(
						() -> new ArrayList<>(), 
						(l, e) -> l.add(e),
						(l1, l2) -> l1.addAll(l2));

		System.out.println(lista);
		System.out.println(collect);

		Set<String> x = lista.stream()
				.collect(
						() -> new HashSet<>(), 
						(l, e) -> l.add(e.toString()),
						(l1, l2) -> l1.addAll(l2));
		System.out.println(x);
		
		
		// toList
		List<Integer> collect2 = lista.stream().collect(Collectors.toList());
		System.out.println(collect2);

		List<Integer> collec2 = lista.stream().filter((n) -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(collec2);

		// toSet
		Set<Integer> collect3 = lista.stream().filter((n) -> n % 2 == 0).collect(Collectors.toSet());
		System.out.println(collect3);

		// toCollection
		Set<Integer> collect4 = lista.stream().filter((n) -> n % 2 == 0)
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
		System.out.println(collect4);

		LinkedList<Integer> collect5 = lista.stream().filter((n) -> n % 2 == 0)
				.collect(Collectors.toCollection(() -> new LinkedList<>()));
		System.out.println(collect5);

		// joining
		String string = lista.stream().map((n) -> n.toString()).collect(Collectors.joining());
		System.out.println(string);

		String string2 = lista.stream().map((n) -> n.toString()).collect(Collectors.joining("-"));
		System.out.println(string2);

		// averaging
		Double media = lista.stream().collect(Collectors.averagingInt(n -> n.intValue()));
		System.out.println(media);

		// summing
		Integer soma = lista.stream().collect(Collectors.summingInt(n -> n.intValue()));
		System.out.println(soma);

		// summarizing
		IntSummaryStatistics somarizacao = lista.stream().collect(Collectors.summarizingInt(n -> n.intValue()));

		System.out.println("---");
		System.out.println(somarizacao.getAverage());
		System.out.println(somarizacao.getCount());
		System.out.println(somarizacao.getMax());
		System.out.println(somarizacao.getMin());
		System.out.println(somarizacao.getSum());

		// counting
		Long qt = lista.stream().filter((n) -> n % 2 == 0).collect(Collectors.counting());
		System.out.println(qt);

		// max / min
		Optional<Integer> max = lista.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println(max);

		Optional<Integer> min = lista.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
		System.out.println(min);

		lista.stream().collect(Collectors.minBy(Comparator.naturalOrder())).ifPresent(System.out::println);
		;

		// groupingby
		Map<Integer, List<Integer>> collect6 = lista.stream().collect(Collectors.groupingBy((n) -> n % 3));
		System.out.println(collect6);

		// partitioningBy
		Map<Boolean, List<Integer>> collect7 = lista.stream().collect(Collectors.partitioningBy((n) -> n % 2 == 0));
		System.out.println(collect7);
		
		//toMap
		Map<Integer, Integer> collect8 = lista.stream().collect(Collectors.toMap(n -> n, n -> n * 2));
		System.out.println(collect8);
		
		Map<Integer, Double> collect9 = lista.stream().collect(Collectors.toMap(n -> n, n -> Math.pow(n.doubleValue() , 5)));
		System.out.println(collect9);



//
//		//reduce - concatenação 
//		Optional<String> concatenacao = list.stream()
//			.reduce((s1, s2) -> s1.concat(s2));
//		
//		System.out.println(concatenacao.get());
//
//		// ATENCAO - NAO USE SUBTRACAO COM REDUCE
//		//reduce - subtração 
//		Optional<Integer> subtracao = lista.stream()
//			.reduce((n1, n2) -> n1 - n2);
//		
//		System.out.println(subtracao.get());
//		
//		//reduce - VALOR DE IDENTIDADE - soma 
//		Integer soma2 = lista.stream()
//			.reduce(0, (n1, n2) -> n1 + n2);
//		
//		//reduce - VALOR DE IDENTIDADE - soma 
//		Integer soma3 = listaVazia.stream()
//			.reduce(0, (n1, n2) -> n1 + n2);
//
//		System.out.println(soma2);
//		System.out.println(soma3);
//
//		//reduce - VALOR DE IDENTIDADE - multiplicação 
//		Integer multiplicacao2 = lista.stream()
//			.reduce(1, (n1, n2) -> n1 * n2);
//		
//		System.out.println(multiplicacao2);
//
//		//reduce - VALOR DE IDENTIDADE - concatenação 
//		String concatenacao2 = list.stream()
//			.reduce("", (s1, s2) -> s1.concat(s2));
//		
//		System.out.println(concatenacao2);
//		
//		//reduce - menor valor
//		DoubleStream.of(1.5, 2.9, 6.7)
//			.forEach(System.out::println);
//
//		System.out.println(DoubleStream.of(1.5, 2.9, 6.7)
//				.reduce((d1, d2) -> Math.min(d1, d2)));
//		
//		System.out.println(DoubleStream.of(1.5, 2.9, 6.7)
//				.reduce(Double.POSITIVE_INFINITY, (d1, d2) -> Math.min(d1, d2)));
//
//		//reduce - FUNCAO DE COMBINACAO - soma 
//		Integer soma4 = lista.stream()
//			.reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
//		
//		System.out.println(soma4);
//		
//		//reduce - FUNCAO DE COMBINACAO - map + combiner 
//		Optional<String> reduce = lista.stream()
//			.map(n1 -> n1.toString())
//			.reduce((n1, n2) -> n1.concat(n2));
//		
//		System.out.println(reduce);
//		
//
//		String reduce2 = lista.stream()
//				.reduce("", 
//						(n1, n2) -> n1.toString().concat(n2.toString()), 
//						(n1, n2) -> n1.concat(n2)); 
//			
//			System.out.println(reduce2);
//
//		
////		//reduce - multiplicação 
////		Optional<Integer> multiplicacao = lista.stream()
////			.reduce((n1, n2) -> n1 * n2);
////		
////		System.out.println(multiplicacao.get());
////
////		//reduce - concatenação 
////		Optional<String> concatenacao = list.stream()
////			.reduce((s1, s2) -> s1.concat(s2));
////		
////		System.out.println(concatenacao.get())

	}
}
