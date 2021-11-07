package br.com.ex.PadraoProjeto;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

public class FactoryMethod {
	
	// Virtual Construtor

	public static void main(String[] args) {
		// STATIC Factory Methods
		Calendar instance = Calendar.getInstance();
		NumberFormat instance2 = NumberFormat.getInstance();
		List<Integer> of = List.of(1,2,3);
		Integer valueOf = Integer.valueOf("12345");
		Stream<Integer> of2 = Stream.of(1,3,4);
		
		
		
		
		

	}

}
