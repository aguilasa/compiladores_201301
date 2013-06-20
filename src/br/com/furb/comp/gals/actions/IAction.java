package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public interface IAction {
	public static String ESPACO = "  ";
	
	void execute(RegistroSemantico rs, Token token) throws SemanticError ;
}
