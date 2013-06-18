package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_1 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		rs.getCodigo().append(".assembly extern mscorlib { }").append("\n");
		rs.getCodigo().append(String.format(".assembly %s { }", rs.getArquivo())).append("\n");
		rs.getCodigo().append(String.format(".module %s.exe", rs.getArquivo())).append("\n");
		rs.getCodigo().append(String.format(".class public %s {", rs.getArquivo())).append("\n").append(ESPACO);		
		rs.getCodigo().append(".method static public void principal() {").append("\n").append(ESPACO).append(ESPACO);
		rs.getCodigo().append(".entrypoint").append("\n");		
	}

}
