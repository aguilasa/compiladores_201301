package br.com.furb.comp.tela;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class JStatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7188176395686976909L;
	private JLabel lblStatus = new JLabel("");
	private JLabel lblArquivo = new JLabel("");
	private JSeparator separador = new JSeparator();

	/**
	 * Create the panel.
	 */
	public JStatusBar() {
		setBorder(createComponentBorder());
		setPreferredSize(new Dimension(300, 22));
		lblStatus.setBounds(4, 4, 120, 14);
		lblArquivo.setBounds(154, 4, 120, 14);
		separador.setBounds(145, 4, 5, 14);
		separador.setOrientation(SwingConstants.VERTICAL);
		setLayout(null);
		add(lblStatus);
		add(separador);
		add(lblArquivo);
	}

	private static Border createComponentBorder() {
		return BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), BorderFactory.createEmptyBorder(0, 4, 0, 4));
	}

	public void setStatusText(String aText) {
		lblStatus.setText(aText);
	}

	public String getStatusText() {
		return lblStatus.getText();
	}

	public void setArquivoText(String aText) {
		lblArquivo.setText(aText);
		ajustaTamanhoTextoArquivo();
	}

	public String getArquivoText() {
		return lblArquivo.getText();
	}

	private void ajustaTamanhoTextoArquivo() {
		Font font = lblArquivo.getFont();
		FontMetrics metrics = lblArquivo.getFontMetrics(font);
		Rectangle rec = new Rectangle((int) lblArquivo.getBounds().getX(), (int) lblArquivo.getBounds().getY(), metrics.stringWidth(lblArquivo.getText()),
				(int) lblArquivo.getBounds().getHeight());
		lblArquivo.setBounds(rec);
	}
}
