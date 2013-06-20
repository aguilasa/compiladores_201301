package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_6 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();
		modulo.getCodigo().append(ESPACO).append(ESPACO).append("ret").append("\n");
		modulo.getCodigo().append(ESPACO).append("}").append("\n");	
		rs.getEscopos().removeLast();
	}

}
