package br.com.ex.DataHora;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SomandoSubtraindo {

	public static void main(String[] args) {

		Calendar instante = Calendar.getInstance();
		instante.set(2021, Calendar.JULY, 07, 15, 0, 0);
		instante.set(Calendar.MILLISECOND, 0);
		Date data = instante.getTime();
		
		Date now = new Date();
		long dif = now.getTime() - data.getTime();
		long quantidadeDias = TimeUnit.MILLISECONDS.toDays(dif);
		System.out.println(quantidadeDias);
		
		
		
		instante.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println(instante.getTime());

		instante.add(Calendar.MONTH, -5);
		System.out.println(instante.getTime());
		
	}

}
