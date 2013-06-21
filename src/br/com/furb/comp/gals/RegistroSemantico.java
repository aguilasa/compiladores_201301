package br.com.furb.comp.gals;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class RegistroSemantico {
	private String arquivo = "";
	private StringBuilder codigo = new StringBuilder();
	private LinkedList<String> escopos = new LinkedList<String>();
	/* s�mbolos inicialmente s� armazenam identificadores de m�dulos */
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
	 * @return M�dulo que est� no topo da lista de m�dulos
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
