package br.com.furb.comp.gals;

public class Token
{
    private int id;
    private String lexeme;
    private int position;
    private int line;
    private String classe = "";

    public Token(int id, String lexeme, int position, int line, String classe)
    {
        this.id = id;
        this.lexeme = lexeme;
        this.position = position;
        this.line = line;
        this.classe = classe;
    }

    public final int getId()
    {
        return id;
    }

    public final String getLexeme()
    {
        return lexeme;
    }

    public final int getPosition()
    {
        return position;
    }
    
    public final int getLine() {
    	return line;
    }
    
    public final String getClasse() {
    	return classe;
    }

    public String toString()
    {
        return id+" ( "+lexeme+" ) @ "+position;
    };
}
