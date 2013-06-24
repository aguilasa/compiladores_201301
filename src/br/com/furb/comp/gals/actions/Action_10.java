package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_10 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();

		Token identificador = modulo.getIdentificadores().pollLast();
		String lexeme = identificador.getLexeme();

		modulo.getCodigo().append(ESPACO).append(ESPACO).append("stloc ").append(lexeme).append("\n");

	}

}
