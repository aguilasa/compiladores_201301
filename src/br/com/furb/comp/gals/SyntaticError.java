package br.com.furb.comp.gals;

public class SyntaticError extends AnalysisError {
	public SyntaticError(String msg, int position, int line, Token token) {
		super(msg, position, line, token);
	}

	public SyntaticError(String msg) {
		super(msg);
	}

	@Override
	public String getLocalizedMessage() {
		String xTokenStr = getToken().getLexeme().equals("$") ? "fim de programa" : getToken().getLexeme();
		String xEncontrado = "";
		if (getToken().isIdentificador()) {
			xEncontrado = getToken().getClasse() + " (" + xTokenStr + ")";
		} else {
			xEncontrado = xTokenStr;
		}
		return String.format("Erro na linha %d - encontrado %s esperado %s", getLine(), xEncontrado, getMessage());
	}
}
