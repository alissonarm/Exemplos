package br.com.ex.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		List<Contato> lista = Arrays.asList(
				new Contato("Rodrigo", "Curitiba"),
				new Contato("Ana", "Campinas"),
				new Contato("Luiz", "Campinas"),
				new Contato("Carla", "Bauru"));
		System.out.println(lista);

		List<Funcionario> funcionarios = Arrays.asList(
				new Funcionario("José", 44, new BigDecimal(4500.0)),
				new Funcionario("Luana", 23, new BigDecimal(2800.0)),
				new Funcionario("Paulo", 17, new BigDecimal(1300.0)),
				new Funcionario("Guilherme", 28, new BigDecimal(5300.0)),
				new Funcionario("Karina", 32, new BigDecimal(4500.0)));
		System.out.println(funcionarios);

		List<Pessoa> p = Arrays.asList(
				new Pessoa("José", 44, 4500, Arrays.asList("musica","futebol")),
				new Pessoa("Luana", 23, 2800, Arrays.asList("teatro","academia")),
				new Pessoa("Paulo", 17, 1300, Arrays.asList("videogame","leitura")),
				new Pessoa("Guilherme", 28, 5300, Arrays.asList("musica","pescar")),
				new Pessoa("karina", 28, 5300, Arrays.asList("surfar","futebol")),
				new Pessoa("Ana", 19, 1300.0, Arrays.asList("leitura","arte")));
		System.out.println(p);
		
		lista.stream()
			.filter(c -> c.getCidade().equalsIgnoreCase("Campinas"))
			.forEach(System.out::println);
		
		Supplier<ArrayList<Contato>> supplier = ArrayList::new;
		BiConsumer<ArrayList<Contato>, Contato> accumulator = ArrayList::add;
		BiConsumer<ArrayList<Contato>, ArrayList<Contato>> combiner = ArrayList::addAll;
		ArrayList<Contato> filtro = lista.stream()
		.filter(c -> c.getCidade().equalsIgnoreCase("Campinas"))
		.collect(supplier, accumulator, combiner);
		System.out.println(filtro);

		//Sem garantia de retorno do tipo da lista
		List<Contato> filtroB = lista.stream()
				.filter(c -> c.getCidade().equalsIgnoreCase("Campinas"))
				.collect(Collectors.toList());
		System.out.println(filtroB);

		//Com garantia de retorno do tipo da lista
		List<Contato> filtroC = lista.stream()
				.filter(c -> c.getCidade().equalsIgnoreCase("Campinas"))
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println(filtroC);

		//listar funcionarios com idade acima de 25
		List<Funcionario> filtraIdade = funcionarios.stream()
			.filter(f -> f.getIdade() > 25)
			.collect(Collectors.toList());
		System.out.println(filtraIdade);
		
		//listar nomes dos funcionarios
		funcionarios.stream()
			.map(Funcionario::getNome)
			.forEach(System.out::println);

		List<String> nomes = funcionarios.stream()
		.map(Funcionario::getNome)
		.collect(Collectors.toList());
		System.out.println(nomes);

		//listar todos os salarios
		funcionarios.stream()
			.map(Funcionario::getSalario)
			.forEach(System.out::println);
		
		List<BigDecimal> salarios = funcionarios.stream()
				.map(Funcionario::getSalario)
				.collect(Collectors.toList());
		System.out.println(salarios);
		
		//listar todos os salarios sem repetição
		funcionarios.stream()
			.map(Funcionario::getSalario)
			.distinct()
			.forEach(System.out::println);
		
		List<BigDecimal> sal = funcionarios.stream()
				.map(Funcionario::getSalario)
				.distinct()
				.collect(Collectors.toList());
		System.out.println(sal);
		
		//listar qualquer funcionario com idade acima de 18
		funcionarios.stream()
			.filter(f -> f.getIdade() > 18)
			.findAny()
			.ifPresent(System.out::println);
		
		Funcionario f1 = funcionarios.stream()
			.filter(f -> f.getIdade() > 18)
			.findAny()
			.orElse(null);
			System.out.println(f1);
		
		//Quantidade de funcionarios com salario acima de 3000
		long count = funcionarios.stream()
			.filter(f -> f.getSalario().doubleValue() > 3000)
			.count();
		System.out.println(count);
		
		//Media de todos os salarios
		double mediaSalario = funcionarios.stream()
			.mapToDouble(f -> f.getSalario().doubleValue())
			.average()
			.orElse(0);
		System.out.println(mediaSalario);

		//Soma de todos os salarios
		double somaSalario = funcionarios.stream()
			.mapToDouble(f -> f.getSalario().doubleValue())
			.sum();
		System.out.println(somaSalario);

		//Maior salario
		double maiorSalario = funcionarios.stream()
			.mapToDouble(f -> f.getSalario().doubleValue())
			.max().orElse(0);
		System.out.println(maiorSalario);

		Optional<Funcionario> funcionarioComMaiorSalario = funcionarios.stream()
				.max(Comparator.comparing(Funcionario::getSalario));
			System.out.println(funcionarioComMaiorSalario);

		//O menor salario
		double menorSalario = funcionarios.stream()
				.mapToDouble(f -> f.getSalario().doubleValue())
				.min().orElse(0);
		System.out.println(menorSalario);

		Optional<Funcionario> funcionarioComMenorSalario = funcionarios.stream()
			.min(Comparator.comparing(Funcionario::getSalario));
		System.out.println(funcionarioComMenorSalario);

		//Soma de todos os salarios
		double somaSalarioPessoa = p.stream()
			.mapToDouble(Pessoa::getSalario)
			.sum();
		System.out.println(somaSalarioPessoa);

		//Soma de todos os salarios atraves de reduce
		double valorInicial = 0;
		BinaryOperator<Double> acumulador = (x, y) -> x + y;
		
		double somaSalarioPessoaComReduce = p.stream()
			.map(Pessoa::getSalario)
			.reduce(valorInicial, acumulador);
		System.out.println(somaSalarioPessoaComReduce);

		BinaryOperator<Double> acumuladorDebug = (x, y) -> {
			System.out.println("x = " + x  + " y = " + y + "/ x + y ==> " + (x + y));
			return x + y;
		};
		double somaSalarioPessoaComReduceDebug = p.stream()
				.map(Pessoa::getSalario)
				.reduce(valorInicial, acumuladorDebug);
		System.out.println(somaSalarioPessoaComReduceDebug);
		
		
		//Listar os hobbies das pessoas
		
		List<String> listaHobbies = p.stream()
			.flatMap(a -> a.getHobbies().stream())
			.collect(Collectors.toList());
		
		System.out.println(listaHobbies);
			
		List<String> listaHobbiesSemRepeticao = p.stream()
				.flatMap(a -> a.getHobbies().stream())
				.distinct()
				.collect(Collectors.toList());
			
		System.out.println(listaHobbiesSemRepeticao);
		
		Set<String> ConjuntoHobbiesSemRepeticao = p.stream()
				.flatMap(a -> a.getHobbies().stream())
				.collect(Collectors.toSet());
			
		System.out.println(ConjuntoHobbiesSemRepeticao);

		
		//Mapear pessoas por hobbies (chave X valor) - mapa ou dicionario de dados
		
		Map<String, List<String>> HobbiesPorNome = p.stream().collect(Collectors.toMap(Pessoa::getNome, Pessoa::getHobbies));
		System.out.println(HobbiesPorNome);
		
		p.stream().collect(Collectors.toMap(Pessoa::getNome, Pessoa::getHobbies)).forEach((k, v) -> System.out.println(k + "=>" + v));
		
		//Agrupar pessoas por idade
		Map<Integer, List<Pessoa>> grupamentoPorIdade = p.stream().collect(Collectors.groupingBy(Pessoa::getIdade));
		System.out.println(grupamentoPorIdade);

		// Agrupar salario das pessoas por idade
		Map<Integer, List<Double>> grupamentoPorSalarios = p.stream()
				.collect(Collectors.groupingBy(Pessoa::getIdade, Collectors.mapping(Pessoa::getSalario, Collectors.toList())));
		System.out.println(grupamentoPorSalarios);
		
		
		//parallelStream ==> performance
		double sum = p.parallelStream().mapToDouble(Pessoa::getSalario).sum();
		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		
		
	}

}
