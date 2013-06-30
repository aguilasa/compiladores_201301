package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_20 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		// TODO rever se é só isso mesmo
		Modulo modulo = rs.getModuloAtual();
		modulo.getCodigo().append(" or ");
	}

}
