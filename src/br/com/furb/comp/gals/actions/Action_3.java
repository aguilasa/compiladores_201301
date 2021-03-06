package br.com.furb.comp.gals.actions;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.comp.gals.Modulo;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public class Action_3 implements IAction {

	@Override
	public void execute(RegistroSemantico rs, Token token) throws SemanticError {

		// for (Entry<String, Modulo> entry : rs.getModulos().entrySet()) {
		// Modulo modulo = entry.getValue();
		// rs.getCodigo().append(modulo.getCodigo());
		// if (modulo.isMain()) {
		// rs.getCodigo().append("ret").append("\n");
		// rs.getCodigo().append("}").append("\n");
		// }
		// }

		List<String> listModulos = new ArrayList<String>(rs.getModulos().keySet());
		for (int i = listModulos.size() - 1; i >= 0; i--) {
			String key = listModulos.get(i);
			Modulo modulo = rs.getModulos().get(key);
			rs.getCodigo().append(modulo.getCodigo());
			if (modulo.isMain()) {
				rs.getCodigo().append("ret").append("\n");
				rs.getCodigo().append("}").append("\n");
			}
		}

		rs.getCodigo().append("}").append("\n");
	}
}
