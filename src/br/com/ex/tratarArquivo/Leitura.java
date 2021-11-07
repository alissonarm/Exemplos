package br.com.ex.tratarArquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {

	public static void main(String[] args) throws IOException {
		System.out.println("Working directory:" + System.getProperty("user.dir"));

		File file = new File("arquivo.txt");
		
        // desing pattern - DECORATOR
		
		FileInputStream fis = new FileInputStream(file);  //bytes

		InputStreamReader isr = new InputStreamReader(fis); //char
		// System.out.println(isr.read());

		BufferedReader br = new BufferedReader(isr); //string
		
		// System.out.println(br.readLine());
		
		String line = br.readLine();
		
		while (line != null) {
			System.out.println(line);
			line = br.readLine();
		}
		
	}

}
