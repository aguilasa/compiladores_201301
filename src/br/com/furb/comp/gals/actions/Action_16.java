package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_16 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();
		int label = rs.incAndGetLabels();
		String labelName = "r" + label;
		modulo.getCodigo().append("br ").append(labelName).append("\n");

		modulo.getCodigo().append(modulo.getLabels().pop()).append(":").append("\n");
		modulo.getLabels().push(labelName);
	}

}
