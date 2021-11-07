package br.com.dp.strategy;

import java.math.BigDecimal;

public class Strategy_1 {

	// Estrategia - Interface
	// Estrategia - Concreta
	// Contexto
	
	public static void main(String[] args) {
		
		BigDecimal valor = new BigDecimal("10");
		Compra compra = new Compra(valor);
		
		// compra.processarCompra(new PagamentoCartaoCredito());
		 compra.processarCompra(new PagamentoCartaoDebito());
		
	}
}


// -----------------------------------------------

class Compra { // Contexto
	
	BigDecimal valor;
	
	public Compra(BigDecimal valor) {
		this.valor = valor;
	}
	
	void processarCompra(EstrategiaPagamento estrategiaPagamento) {
		estrategiaPagamento.pagar(valor);
	}
}

// ----------------------------------------------------

interface EstrategiaPagamento { // Estrategia - Interface
	void pagar(BigDecimal valor);
}

//----------------------------------------------------
// Estrategia - Concreta
class PagamentoCartaoCredito implements EstrategiaPagamento {

	@Override
	public void pagar(BigDecimal valor) {
		System.out.println("Pagou no credito " + valor );
		
	}
	
}

//----------------------------------------------------
// Estrategia - Concreta
class PagamentoCartaoDebito implements EstrategiaPagamento {

	@Override
	public void pagar(BigDecimal valor) {
		System.out.println("Pagou no debito " + valor );
		
	}
	
}