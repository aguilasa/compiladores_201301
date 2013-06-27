package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Simbolo;
import br.com.furb.comp.gals.Token;

public class Action_4 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		// TODO inserir na tabela de símbolos, se existir erro semantico. Gerar
		// código
		String identificador = token.getLexeme();
		if (rs.getSimbolos().containsKey(identificador)) {
			String mensagem = String.format("Erro na linha %d - identificador (%s) já declarado", token.getLine(), identificador);
			throw new SemanticError(mensagem, token.getPosition(), token.getLine(), token);
		}
		Modulo modulo = new Modulo(identificador);

		rs.getSimbolos().put(identificador, new Simbolo(identificador, token.getTipoMSIL()));
		rs.getEscopos().add(modulo.getIdentificador());
		rs.getModulos().put(modulo.getIdentificador(), modulo);

		// geração de código
		modulo.getCodigo().append(".method public static ").append(token.getTipoMSIL()).append(" ").append(identificador);
	}

}
