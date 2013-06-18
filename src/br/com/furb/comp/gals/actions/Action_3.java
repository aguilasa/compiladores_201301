package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_3 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		rs.getCodigo().append("ret").append("\n");
		rs.getCodigo().append("}").append("\n");	
		rs.getCodigo().append("}").append("\n");	
	}

}
