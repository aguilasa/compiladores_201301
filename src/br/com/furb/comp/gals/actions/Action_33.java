package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.EListaExpressao;
import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_33 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();
		if (modulo.getListaExpressao().equals(EListaExpressao.MODULO)) {
			Token identificador = modulo.getIdentificadores().pollLast();
			String lexeme = identificador.getLexeme();
			int linha = identificador.getLine();
			int posicao = identificador.getPosition();
			String tipoMSIL = identificador.getTipoMSIL();

			// FIXME ver isso depois
			// if (!token.isConst() && !rs.getSimbolos().containsKey(lexeme)) {
			// String mensagem =
			// String.format("Erro na linha %d - identificador (%s) não declarado",
			// linha, lexeme);
			// throw new SemanticError(mensagem, posicao, linha, token);
			// }

			modulo.getCodigo().append(String.format("call %s %s::%s(%s)", tipoMSIL, rs.getArquivo(), lexeme, tipoMSIL)).append("\n");
		}
	}

}
