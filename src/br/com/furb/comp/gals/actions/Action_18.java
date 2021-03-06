package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_18 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();
		int label = rs.incAndGetLabels();
		String labelName = "r" + label;
		String lexeme = token.getLexeme();
		String br = "";
		if ("isTrueDo".equals(lexeme)) {
			br = "brfalse ";
		} else if ("isFalseDo".equals(lexeme)) {
			br = "brtrue ";
		}
		modulo.getCodigo().append(br).append(labelName).append("\n");
		modulo.getLabels().add(labelName);
	}

}
