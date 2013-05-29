package br.com.furb.comp.gals;

public class SemanticError extends AnalysisError
{
    public SemanticError(String msg, int position, int line, Token token)
	 {
        super(msg, position, line, token);
    }

    public SemanticError(String msg)
    {
        super(msg);
    }
}
