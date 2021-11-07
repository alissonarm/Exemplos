package br.com.ex.DataHora;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;


// java 8 - API de data e hora
public class DataHoraJava8 {

	public static void main(String[] args) {

		// LocalDate - Representa uma data : 06/08/1990
		LocalDate hoje = LocalDate.now();
		LocalDate Exld = LocalDate.of(2021, 10, 9);
		LocalDate Exld1 = LocalDate.of(2021, Month.DECEMBER, 9);
		System.out.println(hoje + " , " + Exld + " , " + Exld1 );

		// LocaltIme - Represanta uma hora : 11:45:00
		LocalTime hora = LocalTime.now();
		LocalTime lt = LocalTime.of(21, 10, 30);
		System.out.println(" Hora: " + hora + " , " + LocalTime.of(21, 10, 39));
		
		// LocalDateTime - Representa data e hora : 06/08/1990 11:45:00
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.of(hoje, hora));
		
		
		// Instant - Representa um instante/momento na linha do tempo: millessegundos a
		// partir de 01/01/1970 - 06/08/1990 11:45:00 GMT/UTC
		Instant momento = Instant.ofEpochMilli(687815597425L);
		System.out.println(Instant.now());
		System.out.println(momento);
		
		// ZonedDateTime - Representa localDatetime com TimeZone(fuso horário) -
		// 06/08/1990 11:45:00 GMT-3 (America/Sao Paulo)
		System.out.println(ZonedDateTime.now());
		System.out.println(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Montevideo")));
		
		// java 8 - API de data e hora - Period(trabalha com data) e Duration (armazena tempo)
		System.out.println("java 8 - API de data e hora - Period e Duration");
		System.out.println("================================================");
		
		System.out.println(Period.of(1, 7, 3)); //P1Y7M3D : 1 ano, 7 meses, 3 dias
		System.out.println(Period.ofDays(4));   //P4D : 4 dias
		System.out.println(Period.ofMonths(6));  //P6M : 6 meses
		System.out.println(Period.ofWeeks(2));  //P14D : 14 dias ou 2 semanas 
		System.out.println(Period.ofYears(10));  //P10Y : 10 anos
		
		LocalDate dt1 = hoje.plusDays(3).plusMonths(2).plusYears(1);
		Period resultado = Period.between(hoje, dt1);
		System.out.println(resultado);
		
		System.out.println(resultado.minusDays(3));
		
		System.out.println(Exld.until(Exld1));
		System.out.println(Exld.plus(Period.ofYears(10))); // adicionando um periodo
		
		System.out.println("=========================== Duration");
		System.out.println(Duration.ofDays(1));       //PT24H
		System.out.println(Duration.ofMinutes(500));  //PT8H20M
		System.out.println(Duration.ofSeconds(10, 30));  //PT10.00000003S
		
		System.out.println(Duration.between(hora, lt));
		
		//Exemplo de calculo de idade;
		LocalDate nascimento = LocalDate.of(1975, 9, 7);
		Period idade = Period.between(nascimento, hoje);
		System.out.println(idade);
		
		// java 8 - API de data e hora - LocalDateTime X Instant X ZonedDateTime
		// LocalDateTime - Data + hora 
		// Instant - Data + hora + UTC  (Date) 
		// ZonedDateTime - Data + hora + fuso horario
		
		System.out.println("java 8 - API de data e hora - LocalDateTime X Instant X ZonedDateTime");
		System.out.println("=====================================================================");
		
		System.out.println(Instant.now());
		ZonedDateTime zdt = Instant.now().atZone(ZoneId.of("America/Sao_Paulo"));
		System.out.println(zdt);
		System.out.println(zdt.plusMonths(3));

		System.out.println("java 8 - API de data e hora - Formatação");
		System.out.println("========================================");
		
		// DateTimeFormatter
		// Locale.setDefault(Locale.US);
		
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter dtf2 = DateTimeFormatter.ISO_TIME;
		
		System.out.println(dtf.format(agora));
		System.out.println(dtf1.format(agora));
		System.out.println(dtf2.format(agora));
		
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter f1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		DateTimeFormatter f2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		DateTimeFormatter f3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

		DateTimeFormatter f4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		DateTimeFormatter f5 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
		
		System.out.println(f.format(agora));
		System.out.println(f1.format(agora));
		System.out.println(f2.format(agora));
		System.out.println(f3.format(agora));

		System.out.println(f4.format(ZonedDateTime.now()));
		System.out.println(f5.format(ZonedDateTime.now()));
		
		DateTimeFormatter personalizado = DateTimeFormatter.ofPattern("dd-MMM-yyyy 'as' HH:mm");
		System.out.println(personalizado.format(agora));
		System.out.println(agora.format(personalizado));
		
		TemporalAccessor parse = personalizado.parse("06-out-2021 as 20:48");
		System.out.println(LocalDateTime.from(parse));
		
		DateTimeFormatter personalizadoH = DateTimeFormatter.ofPattern("HH:mm:ss");
		TemporalAccessor parse2 = personalizadoH.parse("20:48:10");
		System.out.println(parse2);
		System.out.println(LocalTime.from(parse2));

		
		
		
		

		
		
		
		
		
	}

}
