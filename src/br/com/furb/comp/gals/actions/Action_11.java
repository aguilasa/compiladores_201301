package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_11 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();

		modulo.getCodigo().append("call string [mscorlib]System.Console::ReadLine()").append("\n");
		Token identificador = modulo.getIdentificadores().poll();
		while (identificador != null) {
			String lexeme = identificador.getLexeme();
			int linha = identificador.getLine();
			int posicao = identificador.getPosition();
			String tipoMSIL = identificador.getTipoMSIL();

			if (rs.getSimbolos().containsKey(lexeme)) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) � um m�dulo e n�o pode ser usado em comandos de entrada (in)", linha, lexeme);
				throw new SemanticError(mensagem, posicao, linha, identificador);
			}

			if (!modulo.getSimbolos().containsKey(lexeme)) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) n�o declarado", linha, lexeme);
				throw new SemanticError(mensagem, posicao, linha, identificador);
			}

			if (tipoMSIL.equals("bool")) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) � do tipo bool e n�o pode ser usado em comandos de entrada (in)", linha, lexeme);
				throw new SemanticError(mensagem, posicao, linha, identificador);
			}

			if (tipoMSIL.equals("int64")) {
				modulo.getCodigo().append(CONVERSAOINT).append("\n");
			}

			if (tipoMSIL.equals("float64")) {
				modulo.getCodigo().append(CONVERSAOFLOAT).append("\n");
			}

			modulo.getCodigo().append("stloc ").append(lexeme).append("\n");

			identificador = modulo.getIdentificadores().poll();
		}

	}

}
