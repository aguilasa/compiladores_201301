package br.com.furb.comp.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultEditorKit.CopyAction;
import javax.swing.text.DefaultEditorKit.CutAction;
import javax.swing.text.DefaultEditorKit.PasteAction;

import org.apache.commons.io.FileUtils;

import br.com.furb.comp.gals.AnalysisError;
import br.com.furb.comp.gals.Lexico;
import br.com.furb.comp.gals.RegistroSemantico;
import br.com.furb.comp.gals.Semantico;
import br.com.furb.comp.gals.Sintatico;
import br.com.furb.comp.util.ResourceManager;

public class Compilador {

	private static final int BUTTONOFFSET = 1;
	private static final int BUTTONWIDTH = 105;
	private static final String MODIFICADO = "Modificado";
	private static final String NAOMODIFICADO = "N�o modificado";
	private static final String EXTENSAO = "ing";
	private JFrame frame;
	private JTextArea textEditor;
	private JTextArea textMessages;
	private JPanel toolBar;
	private JStatusBar statusBar;

	private StringBuilder sbEditor;
	private StringBuilder sbMessages;
	private String statusAnterior;
	private String arquivoAnterior;

	private Lexico lexico;
	private Sintatico sintatico;
	private Semantico semantico;
	private RegistroSemantico rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compilador window = new Compilador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Compilador() {
		setLook();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		toolBar = new JPanel();
		toolBar.setBounds(0, 0, 1000, 80);
		toolBar.setLayout(null);

		statusBar = new JStatusBar();

		textEditor = new JTextArea();
		textEditor.setFont(new Font("Courier New", Font.PLAIN, 13));
		textMessages = new JTextArea();
		textMessages.setFont(new Font("Courier New", Font.PLAIN, 13));
		JScrollPane scrollPane2 = new JScrollPane();

		ResourceManager resMan = ResourceManager.getInstance();
		addButton(toolBar, resMan, "novo", "novo", "[ctrl-n]", KeyEvent.VK_N, InputEvent.CTRL_MASK, listenerNovo());
		addButton(toolBar, resMan, "abrir", "abrir", "[ctrl-a]", KeyEvent.VK_A, InputEvent.CTRL_MASK, listenerAbrir());
		addButton(toolBar, resMan, "salvar", "salvar", "[ctrl-s]", KeyEvent.VK_S, InputEvent.CTRL_MASK, listenerSalvar());
		addButton(toolBar, resMan, "copiar", "copiar", "[crtl-c]", KeyEvent.VK_C, InputEvent.CTRL_MASK, new CopyAction());
		addButton(toolBar, resMan, "colar", "colar", "[ctrl-v]", KeyEvent.VK_V, InputEvent.CTRL_MASK, new PasteAction());
		addButton(toolBar, resMan, "recortar", "recortar", "[ctrl-x]", KeyEvent.VK_X, InputEvent.CTRL_MASK, new CutAction());
		addButton(toolBar, resMan, "compilar", "compilar", "[F8]", KeyEvent.VK_F8, 0, listenerCompilar());
		addButton(toolBar, resMan, "gerar", "gerar c�digo", "[F9]", KeyEvent.VK_F9, 0, listenerGerarCodigo());
		addButton(toolBar, resMan, "equipe", "equipe", "[F1]", KeyEvent.VK_F1, 0, listenerEquipe());

		textEditor.setColumns(20);
		textEditor.setRows(5);
		textEditor.setBorder(new NumberedBorder());

		textEditor.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				statusBar.setStatusText(MODIFICADO);
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				statusBar.setStatusText(MODIFICADO);
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {

			}
		});

		textEditor.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getModifiersEx() == InputEvent.CTRL_DOWN_MASK && e.getKeyCode() == KeyEvent.VK_A) {
					abrir();
					e.consume();
				}
			}
		});

		textMessages.setColumns(20);
		textMessages.setRows(5);
		textMessages.setEditable(false);

		scrollPane2.setViewportView(textEditor);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(statusBar, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE).addComponent(textMessages, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
				.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textMessages, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(statusBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));

		frame.getContentPane().setLayout(groupLayout);

		ImageIcon icone = (ImageIcon) resMan.loadImageIcon("icone");
		if (icone != null) {
			frame.setIconImage(icone.getImage());
		}

		frame.setTitle("Compilador");
	}

	private void setLook() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private int buttonCount = 0;

	private void addButton(JPanel tb, ResourceManager aManager, String aImage, String aLabel, String aHotKeyDesc, int aAccessKey, int aModifier, ActionListener aListener) {
		JButton xButton = new JButton();
		xButton.setBounds(BUTTONOFFSET + (BUTTONWIDTH * buttonCount), 0, BUTTONWIDTH, tb.getHeight());
		xButton.setHorizontalAlignment(SwingConstants.CENTER);
		xButton.setIcon(aManager.loadImageIcon(aImage));
		xButton.setText(String.format("<html><div style=\"text-align:center\">%s<br>%s</div></html>", aLabel, aHotKeyDesc));
		xButton.setFocusable(false);
		xButton.setHorizontalTextPosition(SwingConstants.CENTER);
		xButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		xButton.addActionListener(aListener);
		registerAction(xButton, aAccessKey, aModifier);
		buttonCount++;

		tb.add(xButton);
	}

	private void registerAction(JButton aButton, int aKey, int aModifier) {
		aButton.registerKeyboardAction(aButton.getActionListeners()[0], KeyStroke.getKeyStroke(aKey, aModifier), JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

	private ActionListener listenerNovo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		};
	}

	private ActionListener listenerAbrir() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		};
	}

	private ActionListener listenerSalvar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guardaStatus();
				try {
					salvar();
				} catch (IOException e1) {
					recuperaStatus();
				} catch (Exception e1) {
					recuperaStatus();
				}
			}
		};
	}

	private ActionListener listenerCompilar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isArquivoSalvo()) {
					textMessages.setText("");
					StringBuilder sbMessages = new StringBuilder();

					try {
						compilar();
						sbMessages.append("programa compilado com sucesso");
					} catch (AnalysisError e1) {
						sbMessages = new StringBuilder(e1.getLocalizedMessage());
					}

					textMessages.setText(sbMessages.toString());
				}
			}
		};
	}

	private ActionListener listenerGerarCodigo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isArquivoSalvo()) {
					textMessages.setText("");
					StringBuilder sbMessages = new StringBuilder();

					try {
						compilar();
						String nome = getCaminhoArquivo() + getNomeArquivo() + ".il";
						FileUtils.writeStringToFile(new File(nome), rs.getCodigo().toString());
						sbMessages.append("c�digo objeto gerado com sucesso");
					} catch (AnalysisError e1) {
						sbMessages = new StringBuilder(e1.getLocalizedMessage());
					} catch (IOException e1) {
						sbMessages = new StringBuilder("falha na gera��o do arquivo de c�digo");
					}

					textMessages.setText(sbMessages.toString());
				}
			}
		};
	}

	private ActionListener listenerEquipe() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textMessages.setText("Equipe:\nIngmar Schmidt de Aguiar");
			}
		};
	}

	private void limparEditor() {
		textEditor.setText("");
	}

	private void limparMensagens() {
		textMessages.setText("");
	}

	private void limparStatus() {
		statusBar.setArquivoText("");
		statusBar.setStatusText(NAOMODIFICADO);
	}

	private void novo() {
		limparEditor();
		limparMensagens();
		limparStatus();
	}

	Pattern pattern = Pattern.compile("([^\\s]+(\\.(" + EXTENSAO + "))$)");

	private boolean validaNomeArquivo(String nome) {
		if (nome == null || nome.isEmpty()) {
			return false;
		}
		Matcher matcher = pattern.matcher(nome);
		return matcher.matches();
	}

	private void modificar(String valor) {
		statusBar.setStatusText(valor);
	}

	private void guardaStatus() {
		sbEditor = new StringBuilder(textEditor.getText());
		sbMessages = new StringBuilder(textMessages.getText());
		statusAnterior = statusBar.getStatusText();
		arquivoAnterior = statusBar.getArquivoText();
	}

	private void recuperaStatus() {
		textEditor.setText((sbEditor != null ? sbEditor.toString() : ""));
		textMessages.setText((sbMessages != null ? sbMessages.toString() : ""));
		modificar(statusAnterior);
		statusBar.setArquivoText(arquivoAnterior);
	}

	private void abrir() {
		boolean erro = false;
		DialogoAbrir da = new DialogoAbrir();

		guardaStatus();
		if (da.showDialog(null, "Abrir") == DialogoAbrir.APPROVE_OPTION) {
			if (!validaNomeArquivo(da.getSelectedFile().getName())) {
				JOptionPane.showMessageDialog(frame, "Arquivo inv�lido.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					textEditor.setText("");
					String nomeArquivo = da.getSelectedFile().toString();
					try {
						FileReader file = new FileReader(nomeArquivo);
						BufferedReader in = new BufferedReader(file);
						boolean done = false;
						while (!done) {
							String line = in.readLine();
							if (line == null)
								done = true;
							else
								textEditor.append(line + "\n");
						}
					} catch (FileNotFoundException e1) {
						erro = true;
					} catch (IOException e2) {
						erro = true;
					}
					textMessages.setText("");
					modificar(NAOMODIFICADO);
					statusBar.setArquivoText(nomeArquivo);
				} catch (Exception e1) {
					erro = true;
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			erro = true;
		}

		if (erro) {
			recuperaStatus();
		}
	}

	private void salvar() throws IOException, Exception {
		String nomeArquivo = statusBar.getArquivoText();
		// arquivo novo
		if (nomeArquivo.isEmpty()) {
			DialogoSalvar ds = new DialogoSalvar();

			if (ds.showDialog(null, "Salvar") == DialogoSalvar.APPROVE_OPTION) {
				nomeArquivo = ds.getSelectedFile().getPath();
				if (!validaNomeArquivo(nomeArquivo)) {
					nomeArquivo += "." + EXTENSAO;
				}
			} else {
				return;
			}
		}

		modificar(NAOMODIFICADO);
		statusBar.setArquivoText(nomeArquivo);

		File file = new File(nomeArquivo);

		if (!file.exists()) {
			if (!file.createNewFile()) {
				throw new Exception("N�o foi poss�vel criar o arquivo!");
			}
		}

		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(textEditor.getText());
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
		textMessages.setText("");
	}

	private boolean isArquivoSalvo() {
		if (getNomeArquivo().isEmpty() || statusBar.getStatusText().equals(MODIFICADO)) {
			Object[] options = { "Sim", "N�o" };
			int n = JOptionPane.showOptionDialog(frame, "O arquivo n�o est� salvo.\nPara compilar ou gerar c�digo ser� necess�rio salv�-lo.\nSalvar?", "Salvar arquivo?",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (n == JOptionPane.YES_OPTION) {
				try {
					salvar();
					return !getNomeArquivo().isEmpty() && statusBar.getStatusText().equals(NAOMODIFICADO);
				} catch (IOException e) {
					return false;
				} catch (Exception e) {
					return false;
				}
			}
			return false;
		}
		return true;
	}

	private String getNomeArquivo() {
		File file = new File(statusBar.getArquivoText());
		if (file.exists()) {
			return file.getName().substring(0, file.getName().length() - 4);
		}
		return "";
	}

	private String getCaminhoArquivo() {
		File file = new File(statusBar.getArquivoText());
		if (file.exists()) {
			return file.getPath().substring(0, file.getPath().length() - file.getName().length());
		}
		return "";
	}

	private void compilar() throws AnalysisError {
		lexico = new Lexico();
		sintatico = new Sintatico();
		semantico = new Semantico();
		rs = new RegistroSemantico();
		lexico.setInput(textEditor.getText());
		semantico.setRs(rs);
		rs.setArquivo(getNomeArquivo());
		sintatico.parse(lexico, semantico);
	}

}
