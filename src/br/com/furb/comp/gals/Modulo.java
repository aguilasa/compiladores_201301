package br.com.furb.comp.gals;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Modulo {
	private String identificador;
	private boolean main = false;
	private StringBuilder codigo = new StringBuilder();
	private String operador = "";
	private LinkedList<String> tipos = new LinkedList<String>();
	private LinkedList<String> labels = new LinkedList<String>();
	private LinkedList<Token> identificadores = new LinkedList<Token>();
	private Map<String, Simbolo> simbolos = new LinkedHashMap<String, Simbolo>();
	private EListaExpressao listaExpressao;
	private Set<String> parametros = new LinkedHashSet<String>();

	public Modulo(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public StringBuilder getCodigo() {
		return this.codigo;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public LinkedList<String> getTipos() {
		return tipos;
	}

	public LinkedList<String> getLabels() {
		return labels;
	}

	public LinkedList<Token> getIdentificadores() {
		return identificadores;
	}

	public Map<String, Simbolo> getSimbolos() {
		return simbolos;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public EListaExpressao getListaExpressao() {
		return listaExpressao;
	}

	public void setListaExpressao(EListaExpressao listaExpressao) {
		this.listaExpressao = listaExpressao;
	}

	public Set<String> getParametros() {
		return parametros;
	}

	public void limpar() {
		operador = "";
		tipos.clear();
		labels.clear();
		codigo = new StringBuilder();
		identificadores.clear();
		simbolos.clear();
		parametros.clear();
	}

}
