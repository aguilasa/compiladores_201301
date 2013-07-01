package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_10 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		// TODO verificar se existe
		Modulo modulo = rs.getModuloAtual();

		Token identificador = modulo.getIdentificadores().pollLast();
		String tipo = modulo.getTipos().pollLast();
		if (!tipo.equalsIgnoreCase(identificador.getTipoMSIL())) {
			throw new SemanticError(String.format("Erro na linha %s – tipos incompatíveis em comando de atribuição (%s, %s)", identificador.getLine(), identificador.getTipoMSIL(), tipo));
		}

		String lexeme = identificador.getLexeme();

		modulo.getCodigo().append("stloc ").append(lexeme).append("\n");
	}
}
