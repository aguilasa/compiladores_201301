package br.com.furb.comp.gals;

public class Token {
	private int id;
	private String lexeme;
	private int position;
	private int line;
	private String classe = "";

	public Token(int id, String lexeme, int position, int line, String classe) {
		this.id = id;
		this.lexeme = lexeme;
		this.position = position;
		this.line = line;
		this.classe = classe;
	}

	public final int getId() {
		return id;
	}

	public final String getLexeme() {
		return lexeme;
	}

	public final int getPosition() {
		return position;
	}

	public final int getLine() {
		return line;
	}

	public final String getClasse() {
		return classe;
	}

	public boolean isIdentificador() {
		switch (id) {
		case Constants.t_id_int:
		case Constants.t_id_float:
		case Constants.t_id_string:
		case Constants.t_id_bool:
		case Constants.t_const_int:
		case Constants.t_const_float:
		case Constants.t_const_string:
			return true;
		}
		return false;
	}
	
	public String getTipoMSIL() {
		switch (id) {
		case Constants.t_id_int:
			return "int64";
		case Constants.t_id_float:
			return "float64";
		case Constants.t_id_string:
			return "string";
		case Constants.t_id_bool:
			return "bool";
		case Constants.t_const_int:
			return "int64";
		case Constants.t_const_float:
			return "float64";
		case Constants.t_const_string:
			return "string";
		}
		
		return "";		
	}

	public String toString() {
		return id + " ( " + lexeme + " ) @ " + position;
	};
}
