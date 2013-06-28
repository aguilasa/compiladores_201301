package br.com.furb.comp.tests;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.furb.comp.gals.AnalysisError;
import br.com.furb.comp.gals.Lexico;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.Semantico;
import br.com.furb.comp.gals.Sintatico;

public class Compilador extends TestCase {
	StringBuilder sbMessages;
	Lexico lexico;
	Sintatico sintatico;
	Semantico semantico;
	RegistroSemantico rs;

	@Override
	public void setUp() {
		sbMessages = new StringBuilder();
		lexico = new Lexico();
		sintatico = new Sintatico();
		semantico = new Semantico();
		rs = new RegistroSemantico();
	}

	@Test
	public void testCompilar001() {
		semantico.setRs(rs);
		rs.setArquivo("entrada_01");
		StringBuilder sbEntrada = new StringBuilder();
		Utils.carregaArquivo("arquivos/entrada_01.ing", sbEntrada);
		StringBuilder sbSaida = new StringBuilder();
		Utils.carregaArquivo("arquivos/saida_01.txt", sbSaida);

		lexico.setInput(sbEntrada.toString());

		try {
			sintatico.parse(lexico, semantico);
			sbMessages.append("programa compilado com sucesso");
			System.out.println(rs.getCodigo().toString());
		} catch (AnalysisError e) {
			sbMessages = new StringBuilder(e.getLocalizedMessage());
		}

		assertEquals("programa compilado com sucesso", sbMessages.toString());
		comparaTexto(sbSaida.toString(), rs.getCodigo().toString());
	}

	@Test
	public void testCompilar002() {
		semantico.setRs(rs);
		rs.setArquivo("entrada_02");
		StringBuilder sbEntrada = new StringBuilder();
		Utils.carregaArquivo("arquivos/entrada_02.ing", sbEntrada);
		StringBuilder sbSaida = new StringBuilder();
		Utils.carregaArquivo("arquivos/saida_02.txt", sbSaida);

		lexico.setInput(sbEntrada.toString());

		try {
			sintatico.parse(lexico, semantico);
			sbMessages.append("programa compilado com sucesso");
			System.out.println(rs.getCodigo().toString());
		} catch (AnalysisError e) {
			sbMessages = new StringBuilder(e.getLocalizedMessage());
		}

		assertEquals("programa compilado com sucesso", sbMessages.toString());
		comparaTexto(sbSaida.toString(), rs.getCodigo().toString());
	}

	@Test
	public void testCompilar003() {
		semantico.setRs(rs);
		rs.setArquivo("entrada_03");
		StringBuilder sbEntrada = new StringBuilder();
		Utils.carregaArquivo("arquivos/entrada_03.ing", sbEntrada);
		StringBuilder sbSaida = new StringBuilder();
		Utils.carregaArquivo("arquivos/saida_03.txt", sbSaida);

		lexico.setInput(sbEntrada.toString());

		try {
			sintatico.parse(lexico, semantico);
			sbMessages.append("programa compilado com sucesso");
			System.out.println(rs.getCodigo());
		} catch (AnalysisError e) {
			sbMessages = new StringBuilder(e.getLocalizedMessage());
		}

		assertEquals("programa compilado com sucesso", sbMessages.toString());
		comparaTexto(sbSaida.toString(), rs.getCodigo().toString());
	}

	@Test
	public void testCompilar004() {
		semantico.setRs(rs);
		rs.setArquivo("entrada_04");
		StringBuilder sbEntrada = new StringBuilder();
		Utils.carregaArquivo("arquivos/entrada_04.ing", sbEntrada);
		StringBuilder sbSaida = new StringBuilder();
		Utils.carregaArquivo("arquivos/saida_04.txt", sbSaida);

		lexico.setInput(sbEntrada.toString());

		try {
			sintatico.parse(lexico, semantico);
			sbMessages.append("programa compilado com sucesso");
			System.out.println(rs.getCodigo());
		} catch (AnalysisError e) {
			sbMessages = new StringBuilder(e.getLocalizedMessage());
		}

		assertEquals("programa compilado com sucesso", sbMessages.toString());
		comparaTexto(sbSaida.toString(), rs.getCodigo().toString());
	}

	private void comparaTexto(String s1, String s2) {
		String[] sp1 = s1.split("\n");
		String[] sp2 = s2.split("\n");
		int count = (sp1.length >= sp2.length) ? sp2.length : sp1.length;
		for (int i = 0; i < count; i++) {
			if (!sp1[i].trim().equalsIgnoreCase(sp2[i].trim())) {
				fail(String.format("Linha %s, esperado %s, encontrado %s", (i + 1), sp1[i].trim(), sp2[i].trim()));
			}
		}
	}
}
