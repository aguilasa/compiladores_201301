package br.com.furb.comp.gals;

public class SyntaticError extends AnalysisError
{
    public SyntaticError(String msg, int position, int line, String token)
	 {
        super(msg, position, line, token);
    }

    public SyntaticError(String msg)
    {
        super(msg);
    }
    
    @Override
	public String getLocalizedMessage() {
		return String.format("Erro na linha %d - encontrado %s esperado %s", getLine(), getToken(), getMessage());
	}
}
