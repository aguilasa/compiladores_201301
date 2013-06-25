package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_31 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();

		Token identificador = modulo.getIdentificadores().pollLast();
		// while (identificador != null) {
		String lexeme = identificador.getLexeme();
		int linha = identificador.getLine();
		int posicao = identificador.getPosition();

		if (!modulo.getSimbolos().containsKey(lexeme)) {
			String mensagem = String.format("Erro na linha %d - identificador (%s) não declarado", linha, lexeme);
			throw new SemanticError(mensagem, posicao, linha, identificador);
		}

		modulo.getCodigo().append("ldloc ").append(lexeme).append("\n");

		// identificador = modulo.getIdentificadores().poll();
		// }
	}

}
