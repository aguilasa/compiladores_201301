package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_1 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = new Modulo(rs.getArquivo());
		modulo.getCodigo().append(".assembly extern mscorlib {}").append("\n");
		modulo.getCodigo().append(String.format(".assembly %s{}", rs.getArquivo())).append("\n");
		modulo.getCodigo().append(String.format(".module %s.exe", rs.getArquivo())).append("\n");
		modulo.getCodigo().append(String.format(".class public %s{", rs.getArquivo())).append("\n").append(ESPACO);
		modulo.getCodigo().append(".method static public void principal()").append("\n").append(ESPACO).append("{").append(ESPACO).append(ESPACO);
		modulo.getCodigo().append(" .entrypoint").append("\n");

		modulo.setMain(true);
		rs.getEscopos().add(modulo.getIdentificador());
		rs.getModulos().put(modulo.getIdentificador(), modulo);
	}

}
