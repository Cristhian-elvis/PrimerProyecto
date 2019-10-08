/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockdenotas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Cristhian Elvis
 */
public class BlockDeNotas extends JFrame {

	/**
	 * @param args the command line arguments
	 */
	public BlockDeNotas() throws HeadlessException {
		super("Sin Título:Notepad");
		initComponents();
	}

	private void initComponents() {
		setSize(new Dimension(400, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bandera = 0;
		menubar = new JMenuBar();
		archivo = new JMenu("Archivo");
		edicion = new JMenu("Edicion");
		formato = new JMenu("Formato");
		vista = new JMenu("Vista");
		areatexto = new JTextArea();
		Narchivo = null;
		//document

		Ajuste_línea = new JCheckBoxMenuItem(new acciones("Ajuste de línea", ""));
		formato.add(Ajuste_línea);

		archivo.add(new acciones("Nuevo", "ctrl N"));
		archivo.add(new acciones("Abrir", "ctrl A"));
		archivo.add(new acciones("Guardar", "ctrl G"));
		archivo.add(new acciones("Guardar como...", ""));
		archivo.addSeparator();
		archivo.add(new acciones("Salir", ""));

		formato.add(new acciones("Fuentes", ""));

		areatexto.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				bandera++;
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				bandera--;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		//formato.add(new acciones("Ajuste de línea",""));
		menubar.add(archivo);
		menubar.add(edicion);
		menubar.add(formato);
		menubar.add(vista);
		//____________________________________________________________________//
		setJMenuBar(menubar);
		add(areatexto, BorderLayout.CENTER);
	}

	private class acciones extends AbstractAction {

		public acciones(String name, String key) {
			putValue(Action.NAME, name);
			//putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(key));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Ajuste_línea) {
				areatexto.setLineWrap(Ajuste_línea.isSelected());
				return;
			}
			if ("Nuevo".equals(e.getActionCommand())) {
				areatexto.setText("");
				return;
			}
			if ("Abrir".equals(e.getActionCommand())) {
				archivoAbrir = new JFileChooser();
				if (archivoAbrir.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (archivoAbrir.getSelectedFile().exists()) {
						try {
							Narchivo = archivoAbrir.getSelectedFile();
							new Fichero.Abrir(Narchivo, areatexto);
						} catch (IOException ex) {
							Logger.getLogger(BlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
						}
						setTitle(Narchivo.getName() + ":Notepad");
					} else {
						System.out.println("Error");
					}
				}
				return;
			}
			if ("Guardar".equals(e.getActionCommand())) {
				if (Narchivo != null) {
					try {
						new Fichero.guardarComo(Narchivo, areatexto);
					} catch (IOException ex) {
						Logger.getLogger(BlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
					}
				} else {
					saveFile();
				}
				return;
			}
			if ("Guardar como...".equals(e.getActionCommand())) {
				saveFile();
				return;
			}
			if ("Salir".equals(e.getActionCommand())) {
				System.out.println("Salido XD");
				return;
			}
			if ("Fuentes".equals(e.getActionCommand())) {
				new Dialogfuentes(areatexto).setVisible(true);
			}

		}

		private void saveFile() {

			archivoGuardarComo = new JFileChooser();
			FileNameExtensionFilter fnef = new FileNameExtensionFilter(".txt", "txt");
			archivoGuardarComo.setFileFilter(fnef);
			if (archivoGuardarComo.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					Narchivo = archivoGuardarComo.getSelectedFile();
					new Fichero.guardarComo(Narchivo, areatexto);
				} catch (IOException ex) {
					Logger.getLogger(BlockDeNotas.class.getName()).log(Level.SEVERE, null, ex);
				}
				setTitle(Narchivo.getName() + ":Notepad");
			}
		}

	}

	public static void main(String[] args) {
		// TODO code application logic here
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BlockDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BlockDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BlockDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BlockDeNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		new BlockDeNotas().setVisible(true);
	}
	private JMenuBar menubar;
	private JMenu archivo, edicion, formato, vista;
	private JCheckBoxMenuItem Ajuste_línea;
	private JTextArea areatexto;
	private JFileChooser archivoGuardarComo, archivoAbrir;
	private File Narchivo;
	private int bandera;
}
