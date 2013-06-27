package br.com.furb.comp.gals;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Modulo {
	private String identificador;
	private boolean main = false;
	private StringBuilder codigo = new StringBuilder();
	private String operador = "";
	private Stack<String> tipos = new Stack<String>();
	private LinkedList<String> labels = new LinkedList<String>();
	private LinkedList<Token> identificadores = new LinkedList<Token>();
	private Map<String, Simbolo> simbolos = new LinkedHashMap<String, Simbolo>();
	private EListaExpressao listaExpressao;

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

	public Stack<String> getTipos() {
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

	public void limpar() {
		operador = "";
		tipos.clear();
		labels.clear();
		codigo = new StringBuilder();
		identificadores.clear();
		simbolos.clear();
	}

}
