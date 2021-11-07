package br.com.ex.DataHora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;

public class ExemploLocalDate {

	public static void main(String[] args) throws ParseException {

		//grupo de classes Local não possui informaçao de timezone
		// yyyy-MM-dd
		// Utiliza um Factory Method
		LocalDate date = LocalDate.of(2021, 9, 10);
		LocalDate date2 = LocalDate.of(2021, Month.SEPTEMBER, 30);
		
		LocalTime time = LocalTime.of(10, 30, 15);
		LocalTime time2 = LocalTime.of(11, 10);
		
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		LocalDate dataAtual = LocalDate.now();
		LocalTime horaAtual = LocalTime.now();
		
		Month mesAtual = dataAtual.getMonth();
		int diaDoMes = dataAtual.getDayOfMonth();
		DayOfWeek dayOfWeek = dataAtual.getDayOfWeek();
		
		int hora = horaAtual.getHour();
				
		System.out.println(date + " ==> " + date2 + " ==> " + time + " ==> " + time2 + " " + dateTime + " - " + hora);
		System.out.println(dataAtual + " ==> " + horaAtual + " => " + mesAtual + " => " + diaDoMes + " => " + dayOfWeek );;
		
		System.out.println("===================================");
		
		LocalDate mesAlterada = dataAtual.withMonth(3);
		LocalDate diaEmesAlterados = dataAtual.withMonth(2).withDayOfMonth(25);
		
		LocalTime horaAlterada = horaAtual.withHour(22);
		LocalTime horaEminutosAlterados = horaAtual.withHour(22).withMinute(00);
		
		System.out.println(mesAlterada + " , " + diaEmesAlterados + " , " + horaAlterada + " , " + horaEminutosAlterados);
		
		System.out.println("===================================");
		
		LocalDate ultimoDiaDoMes = date.with(TemporalAdjusters.lastDayOfMonth());
		LocalDate primeiroDiaDoMes = date.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate proximoDomingo = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		LocalDate domingoAnterior = date.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime localDateTime = now.with(time2);
		System.out.println(localDateTime);
		System.out.println(ultimoDiaDoMes + " , " + primeiroDiaDoMes + " , " + date.getDayOfWeek() + " , " + proximoDomingo + " , " + domingoAnterior);
		
		System.out.println("===================================");
		System.out.println(date.isBefore(date2));
		System.out.println(date.isAfter(date2));
		System.out.println(date.equals(date2));
		
		System.out.println("===================================");
		
		System.out.println(ZonedDateTime.now());
		System.out.println(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));  // "Australia/Sydney"
		System.out.println(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).getOffset());
		System.out.println(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).getZone());
		
		System.out.println("===================================");
		
		System.out.println(Instant.now()); // ISO 8601 - UTC 
		System.out.println(Instant.now().toEpochMilli()); // 	Quantidade de milli segundos 
		System.out.println(Instant.now().getEpochSecond()); // 
		
		System.out.println(System.currentTimeMillis()); //
		
		System.out.println(Instant.now().isAfter(Instant.now())); 
		System.out.println(Instant.now().isBefore(Instant.now()));
		System.out.println(Instant.now().equals(Instant.now()));
		
		System.out.println("===================================");
		
		LocalDate hoje = LocalDate.of(2021, 10, 10);
		System.out.println(hoje.plusDays(1));
		System.out.println(hoje.plusDays(1).plusMonths(2).plusYears(1));
		
		LocalDateTime agora = LocalDateTime.of(2021, 10, 1, 8, 2, 1, 0 );
		System.out.println(agora.minusDays(1));
		
		System.out.println("===================================");
		
		System.out.println(Period.ofWeeks(3));
		System.out.println(Period.ofYears(2));
		System.out.println(Period.ofDays(10));
		System.out.println(Period.ofYears(2).plusMonths(6).plusDays(15));
		System.out.println(Period.ofYears(2).minusMonths(3));
		System.out.println(Period.ofYears(2).plusMonths(6).plusDays(15).getChronology());
		System.out.println(Period.ofYears(2).plusMonths(6).plusDays(15).getDays());
		
		System.out.println("===================================");
		System.out.println(Duration.ofHours(6));
		System.out.println(Duration.ofHours(6).getSeconds());
		System.out.println(Duration.parse("PT30M"));

		System.out.println("===================================");

		LocalDate inicio = LocalDate.of(2021, 01, 2);
		LocalDate fim = LocalDate.of(2021, 01, 10);
		
		System.out.println(ChronoUnit.DAYS.between(inicio, fim));
		System.out.println(Period.between(inicio, fim));
		// System.out.println(Duration.between(inicio, fim));
		
		System.out.println("===================================");
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
		DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.ENGLISH);
		System.out.println(formato.format(hoje));
		System.out.println(formato2.format(hoje));
		System.out.println(formato3.format(hoje));
		
		
		ZonedDateTime zoned = ZonedDateTime.now();
		DateTimeFormatter formatoZoned = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm:ss").withZone(ZoneId.of("America/Sao_Paulo"));
		System.out.println(formatoZoned.format(zoned));

		formatoZoned = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm:ss").withZone(ZoneId.of("Australia/Sydney"));
		System.out.println(formatoZoned.format(zoned));
		
		formatoZoned = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.of("America/Sao_Paulo"));
		System.out.println(formatoZoned.format(zoned));
		
		formatoZoned = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX").withZone(ZoneId.of("America/Sao_Paulo"));
		System.out.println(formatoZoned.format(zoned));
		
		formatoZoned = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXX").withZone(ZoneId.of("America/Sao_Paulo"));
		System.out.println(formatoZoned.format(zoned));
		
		formatoZoned = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX").withZone(ZoneId.of("America/Sao_Paulo"));
		System.out.println(formatoZoned.format(zoned));
		
		formato = DateTimeFormatter.ofPattern("yyyy uuuu GGGG");
		System.out.println(formato.format(hoje));
		
		// Parsear = transformar uma String em um objeto
		// Formatar =  transformar um objeto em uma String
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime local = localDateTime.parse("10/01/2021 10:30", parser);
		System.out.println(local);
		TemporalAccessor accessor = parser.parse("10/03/2021 11:30");
		System.out.println(accessor.get(ChronoField.DAY_OF_MONTH));
		System.out.println(accessor.get(ChronoField.MONTH_OF_YEAR));
		System.out.println(accessor.get(ChronoField.DAY_OF_WEEK));
		System.out.println(accessor.get(ChronoField.DAY_OF_YEAR));
		
		DateTimeFormatter parser1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mmXXX");
		OffsetDateTime local1 = OffsetDateTime.parse("10/01/2021 10:30-03:00", parser1);
		System.out.println(local1);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		DateTimeFormatter parserComOptionalPattern = new DateTimeFormatterBuilder()
			.appendPattern("dd/MM/yyyy[ HH:mm]")
			.parseDefaulting(ChronoField.HOUR_OF_DAY, 10)
			.parseDefaulting(ChronoField.MINUTE_OF_HOUR, 25)
			.parseDefaulting(ChronoField.OFFSET_SECONDS, ZoneOffset.ofHours(-3).getTotalSeconds())
			.toFormatter();
		
		System.out.println(OffsetDateTime.parse("10/01/2021", parserComOptionalPattern));
		System.out.println(OffsetDateTime.parse("10/01/2021 12:00", parserComOptionalPattern));
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date3 = sdf.parse("33/01/2021");
		System.out.println(sdf.format(date3));

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(LocalDate.parse("2021-01-15"));
		System.out.println(LocalDateTime.parse("2021-01-15T10:30:15"));
		System.out.println(OffsetDateTime.parse("2021-01-15T10:30:15-03:00"));
		System.out.println(ZonedDateTime.parse("2021-01-15T10:30:15-03:00[America/Sao_Paulo]"));
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		Date dateMigracao = new Date();
		System.out.println(dateMigracao.toInstant());
		
		Instant instant = Instant.parse("2021-01-15T10:35:25.123456789Z");
		Date fromDate = Date.from(instant);
		System.out.println(fromDate.toInstant());
		
		LocalDate agora2 = LocalDate.now();
		LocalDateTime atTime = agora2.atTime(16,0);
		ZonedDateTime zonedDateTime = atTime.atZone(ZoneId.of("America/Sao_Paulo"));
		Date from = Date.from(zonedDateTime.toInstant());
		System.out.println(agora2 + " => " + Date.from(zonedDateTime.toInstant()));
		
		System.out.println(from.toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate());
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(Calendar.getInstance().toInstant());
		
		System.out.println(TimeZone.getTimeZone("America/Sao_Paulo").toZoneId());
		
		
		
		

		
	}
	
	

}
