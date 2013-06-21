package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_11 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();

		modulo.getCodigo().append(ESPACO).append(ESPACO).append("call string [mscorlib]System.Console::ReadLine()").append("\n");
		Token identificador = modulo.getIdentificadores().poll();
		while (identificador != null) {
			String lexeme = identificador.getLexeme();
			int linha = identificador.getLine();
			int posicao = identificador.getPosition();
			String tipoMSIL = identificador.getTipoMSIL();

			if (rs.getSimbolos().containsKey(lexeme)) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) é um módulo e não pode ser usado em comandos de entrada (in)", linha, lexeme);
				throw new SemanticError(mensagem, posicao, linha, identificador);
			}

			if (!modulo.getSimbolos().containsKey(lexeme)) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) não declarado", linha, lexeme);
				throw new SemanticError(mensagem, posicao, linha, identificador);
			}

			if (tipoMSIL.equals("bool")) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) é do tipo bool e não pode ser usado em comandos de entrada (in)", linha, lexeme);
				throw new SemanticError(mensagem, posicao, linha, identificador);
			}

			if (!tipoMSIL.equals("string")) {

			}

			identificador = modulo.getIdentificadores().poll();
		}

	}

}
