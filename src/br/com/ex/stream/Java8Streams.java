package br.com.ex.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Streams {

	// stream = fluxo de dados

	public static void main(String[] args) {

		List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

		lista.stream()
			.forEach(e -> System.out.println(e));

		System.out.println("============ Operações intermediarias ===============");

		lista.stream()
			.skip(2)
			.limit(5)
			.distinct()
			.forEach(e -> System.out.println(e));

		System.out.println("===========================");

		lista.stream()
			.filter(e -> e % 2 == 0)
			.map(e -> e * 2)
			.forEach(e -> System.out.println(e));

		System.out.println("============ Operações finais ===============");

		long quantidade = lista.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.count();

		System.out.println(quantidade);

		System.out.println("===========================");
		
		Optional<Integer> min = lista.stream()
				.filter(e -> e % 2 == 0)
				.min(Comparator.naturalOrder());
		
		System.out.println(min.get());
		
		System.out.println("===========================");
		
		Optional<Integer> max = lista.stream()
				.filter(e -> e % 2 == 0)
				.max(Comparator.naturalOrder());
		
		System.out.println(max.get());
		
		System.out.println("===========================");
		
		List<Integer> novaLista = lista.stream()
		 	.filter(e -> e % 2 == 0)
		 	.map(e -> e * 2)
			.collect(Collectors.toList());
		
		System.out.println(novaLista);

		System.out.println("===========================");
		
		Map<Boolean, List<Integer>> mapa = lista.stream()
		 	.map(e -> e * 3)
			.collect(Collectors.groupingBy(e -> e % 2 == 0));
		
		System.out.println(mapa);
		
		Map<Integer, List<Integer>> mapa2 = lista.stream()
				.collect(Collectors.groupingBy(e -> e % 3));
			
			System.out.println(mapa2);
		
		System.out.println("===========================");
			
		String collect = lista.stream()
		 	.map(e -> String.valueOf(e))
			.collect(Collectors.joining());
		
		System.out.println(collect);
		
		String collect2 = lista.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining("-"));
		
		System.out.println(collect2);
		

	}
}
