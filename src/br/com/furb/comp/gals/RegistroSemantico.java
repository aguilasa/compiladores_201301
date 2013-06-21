package br.com.furb.comp.gals;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class RegistroSemantico {
	private String arquivo = "";
	private StringBuilder codigo = new StringBuilder();
	private LinkedList<String> escopos = new LinkedList<String>();
	/* símbolos inicialmente só armazenam identificadores de módulos */
	private Map<String, Simbolo> simbolos = new LinkedHashMap<String, Simbolo>();
	private Map<String, Modulo> modulos = new LinkedHashMap<String, Modulo>();

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public StringBuilder getCodigo() {
		return codigo;
	}


	public LinkedList<String> getEscopos() {
		return escopos;
	}

	public Map<String, Simbolo> getSimbolos() {
		return simbolos;
	}
	
	public Map<String, Modulo> getModulos() {
		return modulos;
	}
	
	/**
	 * 
	 * @return Módulo que está no topo da lista de módulos
	 */
	public Modulo getModuloAtual() {
		return modulos.get(escopos.getLast());
	}

	public void limpar() {
		arquivo = "";
		codigo = new StringBuilder();
		simbolos.clear();
		modulos.clear();
	}

}
