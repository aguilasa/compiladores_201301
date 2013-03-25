package br.com.furb.comp.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
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

import br.com.furb.comp.util.ResourceManager;

public class Compilador {

	private static final String MODIFICADO = "Modificado";
	private static final String NAOMODIFICADO = "Não modificado";
	private JFrame frame;
	private JTextArea textEditor;
	private JTextArea textMessages;
	private JToolBar toolBar;
	private JStatusBar statusBar;
	private JSeparator separador;

	private StringBuilder sbEditor;
	private String statusAnterior;

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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		toolBar = new JToolBar();
		toolBar.setRollover(true);
		toolBar.setFloatable(true);

		statusBar = new JStatusBar();

		separador = new JSeparator();

		textEditor = new JTextArea();
		textEditor.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		textMessages = new JTextArea();
		textMessages.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane1 = new JScrollPane();
		JScrollPane scrollPane2 = new JScrollPane();

		scrollPane1.setViewportView(textMessages);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

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

		textMessages.setColumns(20);
		textMessages.setRows(5);
		textMessages.setEditable(false);

		scrollPane2.setViewportView(textEditor);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(statusBar, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(separador, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(2).addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separador, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(statusBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));

		ResourceManager resMan = ResourceManager.getInstance();

		addButton(toolBar, resMan, "novo", "<html><center>novo<br>[ctrl-n]</center></html>", KeyEvent.VK_N, InputEvent.CTRL_MASK, listenerNovo());
		addButton(toolBar, resMan, "abrir", "<html><center>abrir<br>[ctrl-a]</center></html>", KeyEvent.VK_A, InputEvent.CTRL_MASK, listenerAbrir());
		addButton(toolBar, resMan, "salvar", "<html><center>salvar<br>[ctrl-s]</center></html>", KeyEvent.VK_S, InputEvent.CTRL_MASK, listenerSalvar());
		addButton(toolBar, resMan, "copiar", "<html><center>copiar<br>[crtl-c]</center></html>", KeyEvent.VK_C, InputEvent.CTRL_MASK, new CopyAction());
		addButton(toolBar, resMan, "colar", "<html><center>colar<br>[ctrl-v]</center></html>", KeyEvent.VK_V, InputEvent.CTRL_MASK, new PasteAction());
		addButton(toolBar, resMan, "recortar", "<html><center>recortar<br>[ctrl-x]</center></html>", KeyEvent.VK_X, InputEvent.CTRL_MASK, new CutAction());
		addButton(toolBar, resMan, "compilar", "<html><center>compilar<br>[F8]</center></html>", KeyEvent.VK_F8, 0, listenerCompilar());
		addButton(toolBar, resMan, "gerar", "<html><center>gerar código<br>[F9]</center></html>", KeyEvent.VK_F9, 0, listenerGerarCodigo());
		addButton(toolBar, resMan, "equipe", "<html><center>equipe<br>[F1]</center></html>", KeyEvent.VK_F1, 0, listenerEquipe());

		frame.getContentPane().setLayout(groupLayout);
	}

	private void setLook() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addButton(JToolBar tb, ResourceManager aManager, String aImage, String aText, int aAccessKey, int aModifier, ActionListener aListener) {
		JButton xButton = new JButton();

		xButton.setIcon(aManager.loadImageIcon(aImage));
		xButton.setText(aText);
		xButton.setFocusable(false);
		xButton.setHorizontalTextPosition(SwingConstants.CENTER);
		xButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		xButton.addActionListener(aListener);
		registerAction(xButton, aAccessKey, aModifier);

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
				// TODO
			}
		};
	}

	private ActionListener listenerCompilar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textMessages.setText("compilação de programas ainda não foi implementada");
			}
		};
	}

	private ActionListener listenerGerarCodigo() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textMessages.setText("geração de código ainda não foi implementada");
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

	Pattern pattern = Pattern.compile("([^\\s]+(\\.(ing))$)");

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
		statusAnterior = statusBar.getStatusText();
	}

	private void recuperaStatus() {
		textEditor.setText((sbEditor != null ? sbEditor.toString() : ""));
		modificar(statusAnterior);
	}

	private void abrir() {
		boolean erro = false;
		DialogoAbrir da = new DialogoAbrir();

		guardaStatus();
		if (da.showDialog(null, "Abrir") == DialogoAbrir.APPROVE_OPTION) {
			if (!validaNomeArquivo(da.getSelectedFile().getName())) {
				JOptionPane.showMessageDialog(frame, "Arquivo inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
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
				} catch (Exception e1) {
					erro = true;
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		if (erro) {
			recuperaStatus();
		}
	}
}
