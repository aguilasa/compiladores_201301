package br.com.furb.comp.gals;

public class Semantico implements Constants
{
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Aç?o #"+action+", Token: "+token);
    }	
}
