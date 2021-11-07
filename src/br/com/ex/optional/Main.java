package br.com.ex.optional;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {

		ContatoDAO contatoDAO = new ContatoDAO();
		Optional<Contato> contato = contatoDAO.buscarPorNome("Roberto");

		contato.ifPresent(a -> System.out.println(a.getNome()));
	
	
	}

}
