package br.com.furb.comp.tela;

import javax.swing.JFileChooser;

public class DialogoSalvar extends JFileChooser {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1986910980633215317L;

	public DialogoSalvar() {
		super();
		setDialogTitle("Salvar...");
		setDialogType(SAVE_DIALOG);
		addChoosableFileFilter(new FiltroArquivoCompilador());
	}

}
