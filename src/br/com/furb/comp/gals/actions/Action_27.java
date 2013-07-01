package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_27 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();

		String tipo1 = modulo.getTipos().pollLast();
		String tipo2 = modulo.getTipos().pollLast();

		if (!tipo1.equalsIgnoreCase("int64") && !tipo1.equalsIgnoreCase("float64")) {
			String mensagem = String.format("Erro na linha %d - tipo (%s) inválido", token.getLine(), tipo1);
			throw new SemanticError(mensagem, token.getPosition(), token.getLine(), token);
		}

		if (!tipo2.equalsIgnoreCase("int64") && !tipo2.equalsIgnoreCase("float64")) {
			String mensagem = String.format("Erro na linha %d - tipo (%s) inválido", token.getLine(), tipo2);
			throw new SemanticError(mensagem, token.getPosition(), token.getLine(), token);
		}

		if (!tipo1.equalsIgnoreCase(tipo2)) {
			String mensagem = String.format("Erro na linha %d - tipos (%s, %s) incompatíveis", token.getLine(), tipo1, tipo2);
			throw new SemanticError(mensagem, token.getPosition(), token.getLine(), token);
		}

		String tipo = tipo1;

		modulo.getTipos().add(tipo);
		modulo.getCodigo().append("add").append("\n");
	}

}
