package br.com.ex.DataHora;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class apiCalendar {

	public static void main(String[] args) {

		Calendar agora = Calendar.getInstance();
		
		agora.setLenient(false);      // se false : nao aceita um valor maio que a quantidade de dias no mes respectivo
		
		System.out.println(agora);
		agora.set(Calendar.YEAR, 2021);
		System.out.println(agora);
		agora.set(Calendar.MONTH, Calendar.SEPTEMBER);
		System.out.println(agora);
		agora.set(Calendar.DAY_OF_MONTH, 29);
		System.out.println(agora);
		agora.set(Calendar.HOUR_OF_DAY, 0);
		System.out.println(agora);
		agora.set(Calendar.MINUTE, 0);
		System.out.println(agora);
		agora.set(Calendar.SECOND, 0);
		System.out.println(agora);
		System.out.println(agora.getTimeInMillis());
		System.out.println("-----------------------------");
		
		System.out.println(agora.get(Calendar.YEAR));
		System.out.println(agora.get(Calendar.MONTH));
		System.out.println(agora.get(Calendar.DAY_OF_MONTH));
		
		
		Calendar agora2 = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
		agora2.set(Calendar.YEAR, 2021);
		agora2.set(Calendar.MONTH, Calendar.SEPTEMBER);
		agora2.set(Calendar.DAY_OF_MONTH, 29);
		agora2.set(Calendar.HOUR_OF_DAY, 0);
		agora2.set(Calendar.MINUTE, 0);
		agora2.set(Calendar.SECOND, 0);
		System.out.println(agora2);
		System.out.println("-----------------------------");

		System.out.println(agora2);
		
		
		Date data = agora.getTime();
		System.out.println(data);
		System.out.println(data.getTime());
		System.out.println(data.toString());
		
		System.out.println("-----------------------------");
		System.out.println("-----------------------------");
		System.out.println(TimeZone.getDefault());
		System.out.println(TimeZone.getDefault().getID());
		System.out.println(agora.toString());
		
//		System.out.println("-----------------------------");
//		System.out.println("Timestamp: " + agora.getTime() + " Date: " + agora + " ==> Timezone " + TimeZone.getDefault().getID() );
//		
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Dubai"));
//		System.out.println("Timestamp: " + agora.getTime() + " Date: " + agora + " ==> Timezone " + TimeZone.getDefault().getID() );
//		
//		TimeZone.setDefault(TimeZone.getTimeZone("Australia/Sydney"));
//		System.out.println("Timestamp: " + agora.getTime() + " Date: " + agora + " ==> Timezone " + TimeZone.getDefault().getID() );
//
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//		System.out.println("Timestamp: " + agora.getTime() + " Date: " + agora + " ==> Timezone " + TimeZone.getDefault().getID() );
		
		//Ano => 2021 - 1900 : 121
//		Date data = new Date(121, 8, 30);
//		System.out.println(data);
		
		
		
		
		
		
	}

}
