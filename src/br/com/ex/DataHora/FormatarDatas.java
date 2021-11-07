package br.com.ex.DataHora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FormatarDatas {

	public static void main(String[] args) throws ParseException {

		System.out.println(Locale.getDefault());
		// Locale.setDefault(Locale.ENGLISH);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(date));
		
		Calendar calendar = Calendar.getInstance();
		Date calendarAsDAte = calendar.getTime();
		System.out.println(sdf.format(calendarAsDAte));
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(date));
		
		System.out.println(new SimpleDateFormat("EEE dd/MM/yyyy").format(date));
		System.out.println((new SimpleDateFormat("EEEE dd/MM/yyyy").format(date)));
		System.out.println((new SimpleDateFormat("EEEE dd/MMMM/yyyy").format(date)));
		System.out.println((new SimpleDateFormat("EEEE dd/MMMM/yyyy", Locale.ENGLISH).format(date)));
		System.out.println((new SimpleDateFormat("dd/MMM/yyyy").format(date)));
		
		
		Calendar instante = Calendar.getInstance();
		instante.set(2021, Calendar.SEPTEMBER, 21, 19, 0, 0);
		instante.set(Calendar.MILLISECOND, 0);
		Date data = instante.getTime();
		
		String dataFormatada = sdf.format(data);
		System.out.println(data);
		System.out.println(dataFormatada);
		System.out.println(data.getTime());
		
		SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(parser.parse(dataFormatada));
		System.out.println(parser.parse(dataFormatada).getTime());
		
		
		//UTC -03:00
		String isoDate8601 = "2019-05-12T10:20Z";   // UTC onde o offset 0000
		SimpleDateFormat parser01 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmXXX");
		Date date2 = parser01.parse(isoDate8601);
		System.out.println(date2);
		
		
		
		
		

		
	}

}
