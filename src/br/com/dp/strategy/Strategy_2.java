package br.com.dp.strategy;

import java.math.BigDecimal;

public class Strategy_2 {

	// Estrategia - Interface
	// Estrategia - Concreta
	// Contexto
	
	public static void main(String[] args) {
		
		BigDecimal valor = new BigDecimal("10");
		Compra2 compra = new Compra2(valor);
		
		compra.processarCompra(new PagamentoCartaoCredito2());
		// compra.processarCompra(new PagamentoCartaoDebito2());
		
	}
}


// -----------------------------------------------

class Compra2 { // Contexto
	
	BigDecimal valor;
	
	public Compra2(BigDecimal valor) {
		this.valor = valor;
	}
	
	void processarCompra(EstrategiaPagamento2 estrategiaPagamento) {
		estrategiaPagamento.pagar(this);
	}
}

// ----------------------------------------------------

interface EstrategiaPagamento2 { // Estrategia - Interface
	void pagar(Compra2 compra);
}

//----------------------------------------------------
// Estrategia - Concreta
class PagamentoCartaoCredito2 implements EstrategiaPagamento2 {

	@Override
	public void pagar(Compra2 compra) {
		System.out.println("Pagou no credito " + compra.valor );
		
	}
	
}

//----------------------------------------------------
// Estrategia - Concreta
class PagamentoCartaoDebito2 implements EstrategiaPagamento2 {

	@Override
	public void pagar(Compra2 compra) {
		System.out.println("Pagou no debito " + compra.valor );
		
	}
	
}