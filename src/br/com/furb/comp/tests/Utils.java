package br.com.furb.comp.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
	public static void carregaArquivo(String arquivo, StringBuilder conteudo) {
		try {
			FileReader file = new FileReader(arquivo);
			BufferedReader in = new BufferedReader(file);
			boolean done = false;
			while (!done) {
				String line = in.readLine();
				if (line == null)
					done = true;
				else
					conteudo.append(line.trim() + "\n");
			}
		} catch (FileNotFoundException e1) {
		} catch (IOException e2) {
		}
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		carregaArquivo("arquivos/entrada_01.txt", sb);
		System.out.println(sb.toString());
	}
}
