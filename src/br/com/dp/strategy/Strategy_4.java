package br.com.dp.strategy;

import java.math.BigDecimal;
import static java.lang.System.out;

public class Strategy_4 {

	// Estrategia - Interface
	// Estrategia - Concreta
	// Contexto
	
	public static void main(String[] args) {
		
		BigDecimal valor = new BigDecimal("10");
		Compra4 compra = new Compra4(valor);
		
		compra.processarCompra(v -> out.println("Pagou no credito: " + v));
		// compra.processarCompra(new PagamentoCartaoDebito3());
		
	}
}

// -----------------------------------------------

class Compra4  { // Contexto
	
	BigDecimal valor;
	
	public Compra4(BigDecimal valor) {
		this.valor = valor;
	}
	
	void processarCompra(EstrategiaPagamento4 estrategiaPagamento) {
		estrategiaPagamento.pagar(valor);
	}

}

// ----------------------------------------------------

interface EstrategiaPagamento4 { // Estrategia - Interface
	void pagar(BigDecimal valor);
}

