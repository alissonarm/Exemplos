package br.com.ex.ExemploEnum;

import java.util.EnumMap;
import java.util.EnumSet;

public class main {

	public static void main(String[] args) {

		Transacao t = new Transacao();
		t.setStatus(StatusTransacao.PENDENTE);
		
		System.out.println(t.getStatus());
		
		System.out.println(t.getStatus() == StatusTransacao.PENDENTE);
		
		
		EnumSet<StatusTransacao> cancelaveis = EnumSet.of(StatusTransacao.PENDENTE, StatusTransacao.ANALISE);
		boolean b = cancelaveis.contains(StatusTransacao.PROCESSADA);
		System.out.println(b);
		
		
		EnumMap<StatusTransacao, String> map = new EnumMap(StatusTransacao.class);
		map.put(StatusTransacao.PENDENTE, "Amarela");
		map.put(StatusTransacao.PROCESSADA, "Verde");
		map.put(StatusTransacao.CANCELADA, "Vermelha");
		
		System.out.println(map.get(StatusTransacao.PENDENTE));
		
	}

}
