package br.com.furb.comp.gals;

import br.com.furb.comp.gals.actions.ActionFactory;

public class Semantico implements Constants
{
	private ActionFactory actions = new ActionFactory();
	private RegistroSemantico rs = null;
	
    /**
	 * @return the rs
	 */
	public RegistroSemantico getRs() {
		return rs;
	}

	/**
	 * @param rs the rs to set
	 */
	public void setRs(RegistroSemantico rs) {
		this.rs = rs;
	}

	public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);
        actions.getAction(action).execute(rs, token);
    }	
}
