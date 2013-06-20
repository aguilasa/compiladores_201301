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
		
		modulo.getCodigo().append(ESPACO).append(ESPACO).append(".locals (");
		Token identificador = modulo.getIdentificadores().poll();
		StringBuilder tempCodigo = new StringBuilder();
		while (identificador != null) {
			if (modulo.getSimbolos().containsKey(identificador.getLexeme())) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) já declarado", identificador.getLine(), identificador.getLexeme());
				throw new SemanticError(mensagem, identificador.getPosition(), identificador.getLine(), identificador);
			}
			modulo.getSimbolos().put(identificador.getLexeme(), new Simbolo(identificador.getLexeme(), identificador.getTipoMSIL()));
			if (tempCodigo.length() > 0) {
				tempCodigo.append(", ");
			}
			tempCodigo.append(identificador.getTipoMSIL()).append(" ").append(identificador.getLexeme());
			
			identificador = modulo.getIdentificadores().poll();
		}
		modulo.getCodigo().append(tempCodigo);
		modulo.getCodigo().append(")").append("\n");
	}
}
