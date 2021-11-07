package br.com.ex.tratarArquivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class Escrita {

	public static void main(String[] args) throws IOException {
		System.out.println("Working directory:" + System.getProperty("user.dir"));

		File file = new File("saida.txt");
		
		FileOutputStream fos = new FileOutputStream(file);  //bytes
		
		OutputStreamWriter osw = new OutputStreamWriter(fos); //char
	
		BufferedWriter bw = new BufferedWriter(osw); //string
		
		bw.write("Teste 1");
		bw.newLine();
		bw.write("Teste 2");
		bw.newLine();
		bw.write("Teste 3");
		bw.newLine();
		bw.write("Teste 4");
		bw.newLine();
		bw.write("Teste 5");
		
		bw.close();
		
		PrintStream ps = new PrintStream("saida2.txt");
		ps.println("Primeira linha");
		ps.println("Segunda linha");
		ps.printf("terceira linha ==> %d ", 3);
		ps.close();
		
	}

}
