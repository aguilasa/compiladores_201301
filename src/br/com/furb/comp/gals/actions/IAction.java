package br.com.furb.comp.gals.actions;

import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.SemanticError;
import br.com.furb.comp.gals.Token;

public interface IAction {
	public static String ESPACO = "  ";
	public static String CONVERSAOINT = "call int64 [mscorlib]System.Int64::Parse(string)";
	public static String CONVERSAOFLOAT = "call float64 [mscorlib]System.Double::Parse(string)";

	void execute(RegistroSemantico rs, Token token) throws SemanticError;
}
