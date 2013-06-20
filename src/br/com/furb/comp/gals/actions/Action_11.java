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
			if (!modulo.getSimbolos().containsKey(identificador.getLexeme())) {
				String mensagem = String.format("Erro na linha %d - identificador (%s) não declarado", identificador.getLine(), identificador.getLexeme());
				throw new SemanticError(mensagem, identificador.getPosition(), identificador.getLine(), identificador);
			}
			
			if (!identificador.getTipoMSIL().equals("string")) {
				
			}

			identificador = modulo.getIdentificadores().poll();
		}
		
	}

}
