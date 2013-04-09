package br.com.furb.comp.gals;

public class Lexico implements Constants {
	private int position;
	private int lposition = -1;
	private String input;
	private int line;

	public Lexico() {
		this("");
	}

	public Lexico(String input) {
		setInput(input);
	}

	public void setInput(String input) {
		this.input = input;
		setPosition(0);
		setLine(1);
	}

	public void setPosition(int pos) {
		position = pos;
	}

	public void setLine(int l) {
		line = l;
	}

	public Token nextToken() throws LexicalError {
		if (!hasInput())
			return null;

		int start = position;

		int state = 0;
		int lastState = 0;
		int endState = -1;
		int end = -1;

		while (hasInput()) {
			lastState = state;
			state = nextState(nextChar(), state);

			if (state < 0)
				break;

			else {
				if (tokenForState(state) >= 0) {
					endState = state;
					end = position;
				}
			}
		}
		if (endState < 0 || (endState != state && tokenForState(lastState) == -2)) {
			String simbolo = input.substring(start, position);
			String erro = "Erro na linha " + line + " - ";
			switch(lastState) {
			case 0:
				erro += simbolo + " ";
				break;
			}
			throw new LexicalError(erro + SCANNER_ERROR[lastState], start, line);
		}

		position = end;

		int token = tokenForState(endState);

		if (token == 0)
			return nextToken();
		else {
			String lexeme = input.substring(start, end);
			token = lookupToken(token, lexeme);
			String classe = defineClasse(token);

			return new Token(token, lexeme, start, line, classe);
		}
	}

	private String defineClasse(int token) {
		switch (token) {
		case t_palavra_reservada:
			return "palavra reservada";
		case t_id_int:
		case t_id_float:
		case t_id_string:
		case t_id_bool:
			return "identificador";
		case t_const_int:
			return "constante inteira";
		case t_const_float:
			return "constante real";
		case t_const_string:
			return "constante literal";
		default: {
			if (token >= t_and && token <= t_while) {
				return "palavra reservada";
			} else if (token >= t_TOKEN_24) {
				return "símbolo especial";
			}
		}

		}
		return "classe não definida";
	}

	private int nextState(char c, int state) {
		int start = SCANNER_TABLE_INDEXES[state];
		int end = SCANNER_TABLE_INDEXES[state + 1] - 1;

		while (start <= end) {
			int half = (start + end) / 2;

			if (SCANNER_TABLE[half][0] == c)
				return SCANNER_TABLE[half][1];
			else if (SCANNER_TABLE[half][0] < c)
				start = half + 1;
			else
				// (SCANNER_TABLE[half][0] > c)
				end = half - 1;
		}

		return -1;
	}

	private int tokenForState(int state) {
		if (state < 0 || state >= TOKEN_STATE.length)
			return -1;

		return TOKEN_STATE[state];
	}

	public int lookupToken(int base, String key) {
		int start = SPECIAL_CASES_INDEXES[base];
		int end = SPECIAL_CASES_INDEXES[base + 1] - 1;

		while (start <= end) {
			int half = (start + end) / 2;
			int comp = SPECIAL_CASES_KEYS[half].compareTo(key);

			if (comp == 0)
				return SPECIAL_CASES_VALUES[half];
			else if (comp < 0)
				start = half + 1;
			else
				// (comp > 0)
				end = half - 1;
		}

		return base;
	}

	private boolean hasInput() {
		return position < input.length();
	}

	private char nextChar() {
		if (hasInput()) {
			char c = input.charAt(position);
			if (c == '\n' && position != lposition) {
				lposition = position;
				line++;
			}
			position++;
			return c;
		} else
			return (char) -1;
	}
}
