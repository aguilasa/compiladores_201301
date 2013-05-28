package br.com.furb.comp.gals;

public class LexicalError extends AnalysisError
{
    public LexicalError(String msg, int position, int line, String token)
	 {
        super(msg, position, line, token);
    }

    public LexicalError(String msg)
    {
        super(msg);
    }
}
