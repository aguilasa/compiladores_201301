package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_38 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {
		if (!token.getTipoMSIL().equalsIgnoreCase("int64") || !token.getTipoMSIL().equalsIgnoreCase("float64")) {
			String mensagem = String.format("Erro na linha %d - tipo incompatível (%s)", token.getLine(), token.getTipoMSIL());
			throw new SemanticError(mensagem, token.getPosition(), token.getLine(), token);
		}

		Modulo modulo = rs.getModuloAtual();

		modulo.getCodigo().append("ldc.i8 -1");
		modulo.getCodigo().append("mul");
	}

}
