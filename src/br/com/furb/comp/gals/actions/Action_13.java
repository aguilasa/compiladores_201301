package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.EListaExpressao;
import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_13 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();
		if (modulo.getListaExpressao().equals(EListaExpressao.OUT)) {
			String lexeme = token.getLexeme();
			int linha = token.getLine();
			int posicao = token.getPosition();
			String tipoMSIL = token.getTipoMSIL();

			if (!token.isConst() && !modulo.getSimbolos().containsKey(lexeme)) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) não declarado", linha, lexeme);
				throw new SemanticError(mensagem, posicao, linha, token);
			}

			modulo.getCodigo().append(String.format("call void [mscorlib]System.Console::Write(%s)", tipoMSIL)).append("\n");
		}
	}

}
