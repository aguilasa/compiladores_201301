package br.com.furb.comp.tela;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultEditorKit.CopyAction;
import javax.swing.text.DefaultEditorKit.CutAction;
import javax.swing.text.DefaultEditorKit.PasteAction;

import br.com.furb.comp.util.ResourceManager;

public class Compilador {

	private JFrame frame;
	private JTextArea textEditor;
	private JTextArea textMessages;
	private JToolBar toolBar;

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

		JStatusBar status = new JStatusBar();

		JSeparator separador = new JSeparator();

		textEditor = new JTextArea();
		textEditor.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		textMessages = new JTextArea();
		textMessages.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		JScrollPane scrollPane1 = new JScrollPane();
		JScrollPane scrollPane2 = new JScrollPane();

		scrollPane1.setViewportView(textMessages);
		scrollPane1
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		textEditor.setColumns(20);
		textEditor.setRows(5);
		textEditor.setBorder(new NumberedBorder());

		textMessages.setColumns(20);
		textMessages.setRows(6);
		textMessages.setEditable(false);

		scrollPane2.setViewportView(textEditor);
		scrollPane2
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 784,
						Short.MAX_VALUE)
				.addComponent(status, GroupLayout.DEFAULT_SIZE, 784,
						Short.MAX_VALUE)
				.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 784,
						Short.MAX_VALUE)
				.addComponent(separador, GroupLayout.DEFAULT_SIZE, 784,
						Short.MAX_VALUE)
				.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 784,
						Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(2)
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE,
								324, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separador, GroupLayout.PREFERRED_SIZE,
								10, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(status, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));

		ResourceManager manager = ResourceManager.getInstance();

		ActionListener ac = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textMessages.setText("Equipe:\nIngmar Schmidt de Aguiar");
			}
		};
		addButton(manager, "novo",
				"<html><center>novo<br>[ctrl-n]</center></html>",
				KeyEvent.VK_N, InputEvent.CTRL_MASK, ac);
		addButton(manager, "abrir",
				"<html><center>abrir<br>[ctrl-a]</center></html>",
				KeyEvent.VK_A, InputEvent.CTRL_MASK, ac);
		addButton(manager, "salvar",
				"<html><center>salvar<br>[ctrl-s]</center></html>",
				KeyEvent.VK_S, InputEvent.CTRL_MASK, ac);
		addButton(manager, "copiar",
				"<html><center>copiar<br>[crtl-c]</center></html>",
				KeyEvent.VK_C, InputEvent.CTRL_MASK, new CopyAction());
		addButton(manager, "colar",
				"<html><center>colar<br>[ctrl-v]</center></html>",
				KeyEvent.VK_V, InputEvent.CTRL_MASK, new PasteAction());
		addButton(manager, "recortar",
				"<html><center>recortar<br>[ctrl-x]</center></html>",
				KeyEvent.VK_X, InputEvent.CTRL_MASK, new CutAction());
		addButton(manager, "compilar",
				"<html><center>compilar<br>[F8]</center></html>",
				KeyEvent.VK_F8, 0, ac);
		addButton(manager, "gerar",
				"<html><center>gerar c�digo<br>[F9]</center></html>",
				KeyEvent.VK_F9, 0, ac);
		addButton(manager, "equipe",
				"<html><center>equipe<br>[F1]</center></html>", KeyEvent.VK_F1,
				0, ac);

		frame.getContentPane().setLayout(groupLayout);
	}

	private void setLook() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addButton(ResourceManager aManager, String aImage,
			String aText, int aAccessKey, int aModifier,
			ActionListener aListener) {
		JButton xButton = new JButton();

		xButton.setIcon(aManager.loadImageIcon(aImage));
		xButton.setText(aText);
		xButton.setFocusable(false);
		xButton.setHorizontalTextPosition(SwingConstants.CENTER);
		xButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		xButton.addActionListener(aListener);
		registerAction(xButton, aAccessKey, aModifier);

		toolBar.add(xButton);
	}

	private void registerAction(JButton aButton, int aKey, int aModifier) {
		aButton.registerKeyboardAction(aButton.getActionListeners()[0],
				KeyStroke.getKeyStroke(aKey, aModifier),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
	}
}
