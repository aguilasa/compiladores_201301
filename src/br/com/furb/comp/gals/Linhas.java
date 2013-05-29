package br.com.furb.comp.gals;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton para buscar as linhas do arquivo
 * 
 * @author Ingmar.Aguiar
 * 
 */
public class Linhas {
	private static final Linhas instance = new Linhas();
	private static StringBuilder texto;
	private static Map<Integer, Position> mapa = new HashMap<Integer, Position>();

	private Linhas() {
	}

	public static Linhas getInstance() {
		return instance;
	}

	public void setTexto(String aTexto) {
		texto = new StringBuilder(aTexto);
		processaLinhas();
	}

	private void processaLinhas() {
		mapa.clear();
		int lpos = 0;
		int linha = 0;
		int i = 0;
		for (; i < texto.length(); i++){
			char c = texto.charAt(i);
			if (c == '\n') {
				linha++;
				Position pos = new Position(lpos, i);
				lpos = i + 1;
				mapa.put(linha, pos);
			}
		}
		linha++;
		Position pos = new Position(lpos, i);
		mapa.put(linha, pos);
	}
	
	public int getLinha(int posicao) {
		int linha = -1;
		
		for (Map.Entry<Integer, Position> entry : mapa.entrySet()) {
			if (posicao >= entry.getValue().getIni() && posicao <= entry.getValue().getFim()) {
				return entry.getKey();
			}
		}
		
		return linha;		
	}

}
