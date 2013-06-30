package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_5 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		// geração de código
		Modulo modulo = rs.getModuloAtual();
		modulo.getCodigo().append("{").append("\n");
	}

}
