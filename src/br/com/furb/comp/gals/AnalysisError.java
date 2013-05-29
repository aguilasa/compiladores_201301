package br.com.furb.comp.gals;

public class AnalysisError extends Exception
{
    private int position;
    private int line;
    private Token token;

    public AnalysisError(String msg, int position, int line, Token token)
    {
        super(msg);
        this.position = position;
        this.line = line;
        this.token = token;
    }

    public AnalysisError(String msg)
    {
        super(msg);
        this.position = -1;
        this.line = -1;
    }

    public int getPosition()
    {
        return position;
    }
    
    public int getLine() {
    	return line;
    }
    
    public Token getToken() {
		return token;
	}

    public String toString()
    {
        return super.toString() + ", @ "+position;
    }
}
