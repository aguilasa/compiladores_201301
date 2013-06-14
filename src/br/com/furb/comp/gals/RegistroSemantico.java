package br.com.furb.comp.gals;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RegistroSemantico {
	private String arquivo = "";
	private Stack<String> operador = new Stack<String>();
	private Stack<String> tipos = new Stack<String>();
	private Stack<String> labels = new Stack<String>();
	private StringBuilder codigo = new StringBuilder();
	private static List<String> identificadores = new LinkedList<String>();

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Stack<String> getOperador() {
		return operador;
	}

	public Stack<String> getTipos() {
		return tipos;
	}

	public Stack<String> getLabels() {
		return labels;
	}

	public StringBuilder getCodigo() {
		return codigo;
	}

	public static List<String> getIdentificadores() {
		return identificadores;
	}
	
	public void limpar() {
		arquivo = "";
		operador.clear();
		tipos.clear();
		labels.clear();
		codigo = new StringBuilder();
		identificadores.clear();
	}

}
