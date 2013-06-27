package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Simbolo;
import br.com.furb.comp.gals.Token;

public class Action_4 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		// TODO inserir na tabela de s�mbolos, se existir erro semantico. Gerar
		// c�digo
		String identificador = token.getLexeme();
		if (rs.getSimbolos().containsKey(identificador)) {
			String mensagem = String.format("Erro na linha %d - identificador (%s) j� declarado", token.getLine(), identificador);
			throw new SemanticError(mensagem, token.getPosition(), token.getLine(), token);
		}
		Modulo modulo = new Modulo(identificador);

		rs.getSimbolos().put(identificador, new Simbolo(identificador, token.getTipoMSIL()));
		rs.getEscopos().add(modulo.getIdentificador());
		rs.getModulos().put(modulo.getIdentificador(), modulo);

		// gera��o de c�digo
		modulo.getCodigo().append(".method public static ").append(token.getTipoMSIL()).append(" ").append(identificador);
	}

}
