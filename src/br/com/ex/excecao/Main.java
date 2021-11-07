package br.com.ex.excecao;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		agenda.adiciona("Maria");
		agenda.adiciona("Pedro");
		agenda.adiciona("Rafaela");
		
		String[] nomes = agenda.getNomes();
		
		List<String> lista = null;
		for (String nome : nomes) {
			System.out.println(nome);
			lista = Arrays.asList(nome);
		}
		
		System.out.println("--------------");
		lista.stream()
			.forEach(e -> System.out.println(e));
		
		
		System.out.println("--------------");
		for (int i = 0; i <= nomes.length; i++) {
			
			try {
				if(nomes[i] != null) {
					System.out.println(nomes[i]);
				}
			} catch (ArrayIndexOutOfBoundsException e1) {
//				e1.printStackTrace();
				System.out.println("Erro na posicao " + i);
			}
			
		}

		System.out.println("Fui executado!");
	}
}
