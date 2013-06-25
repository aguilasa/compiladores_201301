package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_26 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();

		String operador = modulo.getOperador();

		if (operador.equals("==")) {
			modulo.getCodigo().append("ceq").append("\n");
		}
		if (operador.equals("!=")) {
			modulo.getCodigo().append("ceq").append("\r").append("ldc.i4.1").append("\r").append("xor").append("\n");
		}
		if (operador.equals("<")) {
			modulo.getCodigo().append("clt").append("\n");
		}
		if (operador.equals("<=")) {
			modulo.getCodigo().append("cgt").append("\r").append("ldc.i4.1").append("\r").append("xor").append("\n");
		}
		if (operador.equals(">")) {
			modulo.getCodigo().append("cgt").append("\n");
		}
		if (operador.equals(">=")) {
			modulo.getCodigo().append("clt").append("\r").append("ldc.i4.1").append("\r").append("xor").append("\n");
		}

		modulo.setOperador("");
	}
}
