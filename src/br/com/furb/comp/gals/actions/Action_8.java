package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Simbolo;
import br.com.furb.comp.gals.Token;

public class Action_8 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		Modulo modulo = rs.getModuloAtual();
		
		modulo.getCodigo().append(".locals (");
		Token identificador = modulo.getIdentificadores().poll();
		StringBuilder tempCodigo = new StringBuilder();
		while (identificador != null) {
			String lexeme = identificador.getLexeme();
			if (rs.getSimbolos().containsKey(lexeme) || modulo.getSimbolos().containsKey(lexeme)) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) já declarado", identificador.getLine(), lexeme);
				throw new SemanticError(mensagem, identificador.getPosition(), identificador.getLine(), identificador);
			}
			modulo.getSimbolos().put(lexeme, new Simbolo(lexeme, identificador.getTipoMSIL()));
			if (tempCodigo.length() > 0) {
				tempCodigo.append(", ");
			}
			tempCodigo.append(identificador.getTipoMSIL()).append(" ").append(lexeme);
			
			identificador = modulo.getIdentificadores().poll();
		}
		modulo.getCodigo().append(tempCodigo);
		modulo.getCodigo().append(")").append("\n");
	}
}
