package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_14 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();
		int label = rs.incAndGetLabels();
		String labelName = "r" + label;
		modulo.getLabels().push(labelName);
		modulo.getCodigo().append("brfalse ").append(labelName).append("\n");
	}

}
