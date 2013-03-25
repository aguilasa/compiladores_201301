package br.com.furb.comp.tela;

import javax.swing.JFileChooser;

public class DialogoAbrir extends JFileChooser {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1986910980633215317L;

	public DialogoAbrir() {
		super();
		setDialogTitle("Abrir...");
		setDialogType(OPEN_DIALOG);
		addChoosableFileFilter(new FiltroArquivoCompilador());
	}

}
