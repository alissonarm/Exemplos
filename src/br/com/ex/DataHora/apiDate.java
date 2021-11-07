package br.com.ex.DataHora;

import java.util.Date;
import java.util.TimeZone;

public class apiDate {

	public static void main(String[] args) {

		Date agora = new Date();
		
		System.out.println(agora);
		System.out.println(agora.getDay());
		System.out.println(agora.getHours());
		System.out.println(agora.getMinutes());
		System.out.println(agora.getMonth());
		System.out.println(agora.getSeconds());
		System.out.println(agora.getTime());
		System.out.println(agora.getTimezoneOffset());
		System.out.println("Ano " + agora.getYear());
		
		System.out.println("-----------------------------");
		System.out.println(TimeZone.getDefault());
		System.out.println(TimeZone.getDefault().getID());
		System.out.println(agora.toString());
		
		System.out.println("-----------------------------");
		System.out.println("Timestamp: " + agora.getTime() + " Date: " + agora + " ==> Timezone " + TimeZone.getDefault().getID() );
		
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Dubai"));
		System.out.println("Timestamp: " + agora.getTime() + " Date: " + agora + " ==> Timezone " + TimeZone.getDefault().getID() );
		
		TimeZone.setDefault(TimeZone.getTimeZone("Australia/Sydney"));
		System.out.println("Timestamp: " + agora.getTime() + " Date: " + agora + " ==> Timezone " + TimeZone.getDefault().getID() );

		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		System.out.println("Timestamp: " + agora.getTime() + " Date: " + agora + " ==> Timezone " + TimeZone.getDefault().getID() );
		
		//Ano => 2021 - 1900 : 121
		Date data = new Date(121, 8, 30);
		System.out.println(data);
		
		
		
		
		
		
	}

}
