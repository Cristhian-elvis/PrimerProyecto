/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockdenotas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Cristhian Elvis
 */
public class Dialogfuentes extends JDialog {

	public static void main(String[] args) {
		new Dialogfuentes(new JTextArea()).setVisible(true);
	}

	public Dialogfuentes(JTextArea textarea) {
		this.textarea = textarea;
		setLayout(null);
		setSize(new Dimension(430, 480));
		setTitle("Fuentes");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);

		initComponents();
	}

	private void initComponents() {
		fuenteL = new JLabel("Fuente:");
		estiloL = new JLabel("Estilo de fuente:");
		tamañoL = new JLabel("Tamaño:");

		listaFuente = new JList(Sfuente);
		listaEstilo = new JList(Sestilo);
		listaTamaño = new JList(Stamaño);

		scrollfuente = new JScrollPane(listaFuente);
		scrollestilo = new JScrollPane(listaEstilo);
		scrolltamaño = new JScrollPane(listaTamaño);

		fuenteF = new JTextField(Sfuente[0]);
		estiloF = new JTextField(Sestilo[0]);
		tamañoF = new JTextField(Stamaño[0]);

		separa1 = new JSeparator();
		separa2 = new JSeparator();
		separa3 = new JSeparator();

		muestraL1 = new JLabel("Muestra");
		muestraL2 = new JLabel("AaBbYyZz", JLabel.CENTER);

		aceptarB = new JButton("Aceptar");
		cancelarB = new JButton("Cancelar");

		fuenteL.setBounds(10, 10, 50, 20);
		estiloL.setBounds(180, 10, 100, 20);
		tamañoL.setBounds(340, 10, 50, 20);

		fuenteF.setBounds(10, 30, 160, 20);
		estiloF.setBounds(180, 30, 150, 20);
		tamañoF.setBounds(340, 30, 74, 20);

		separa1.setBounds(10, 50, 160, 1);
		separa2.setBounds(180, 50, 150, 1);
		separa3.setBounds(340, 50, 74, 1);

		scrollfuente.setBounds(10, 51, 160, 140);
		scrollestilo.setBounds(180, 51, 150, 140);
		scrolltamaño.setBounds(340, 51, 74, 140);

		muestraL1.setBounds(180, 200, 150, 20);
		muestraL2.setBounds(180, 220, 234, 100);

		aceptarB.setBounds(235, 410, 80, 25);
		cancelarB.setBounds(325, 410, 80, 25);

		listaFuente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaEstilo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTamaño.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaFuente.setSelectedIndex(0);
		listaEstilo.setSelectedIndex(0);
		listaTamaño.setSelectedIndex(0);

		muestraL2.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

		fuenteF.addActionListener(this::fuenteFactionPerformed);
		estiloF.addActionListener(this::estiloFactionPerformed);
		tamañoF.addActionListener(this::tamañoFactionPerformed);

		listaEstilo.addListSelectionListener(this::listaEstilo_valueChanged);
		listaFuente.addListSelectionListener(this::listaFuente_valueChanged);
		listaTamaño.addListSelectionListener(this::listaTamaño_valueChanged);

		aceptarB.addActionListener(this::aceptarBactionPerformed);
		cancelarB.addActionListener(this::cancelarBactionPerformed);

		add(fuenteL);
		add(estiloL);
		add(tamañoL);

		add(fuenteF);
		add(estiloF);
		add(tamañoF);

		add(separa1);
		add(separa2);
		add(separa3);

		add(scrollestilo);
		add(scrollfuente);
		add(scrolltamaño);

		add(muestraL1);
		add(muestraL2);

		add(aceptarB);
		add(cancelarB);
	}

	private void fuenteFactionPerformed(ActionEvent evt) {
		textarea.setFont(new Font(String.valueOf(listaFuente.getSelectedValue()), listaEstilo.getSelectedIndex(), Integer.parseInt(String.valueOf(listaTamaño.getSelectedValue()))));
		dispose();
	}

	private void estiloFactionPerformed(ActionEvent evt) {
		textarea.setFont(new Font(String.valueOf(listaFuente.getSelectedValue()), listaEstilo.getSelectedIndex(), Integer.parseInt(String.valueOf(listaTamaño.getSelectedValue()))));
		dispose();
	}

	private void tamañoFactionPerformed(ActionEvent evt) {
		textarea.setFont(new Font(String.valueOf(listaFuente.getSelectedValue()), listaEstilo.getSelectedIndex(), Integer.parseInt(String.valueOf(listaTamaño.getSelectedValue()))));
		dispose();
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	private void listaFuente_valueChanged(ListSelectionEvent evento) {
		if (listaFuente.getSelectedValue() != null) {
			fuenteF.setText(String.valueOf(listaFuente.getSelectedValue()));
			muestraL2.setFont(new Font(String.valueOf(listaFuente.getSelectedValue()), listaEstilo.getSelectedIndex(), Integer.parseInt(String.valueOf(listaTamaño.getSelectedValue()))));
		}
	}

	private void listaEstilo_valueChanged(ListSelectionEvent evento) {
		if (listaEstilo.getSelectedValue() != null) {
			estiloF.setText(String.valueOf(listaEstilo.getSelectedValue()));
			muestraL2.setFont(new Font(String.valueOf(listaFuente.getSelectedValue()), listaEstilo.getSelectedIndex(), Integer.parseInt(String.valueOf(listaTamaño.getSelectedValue()))));
		}
	}

	private void listaTamaño_valueChanged(ListSelectionEvent evento) {
		if (listaTamaño.getSelectedValue() != null) {
			tamañoF.setText(String.valueOf(listaTamaño.getSelectedValue()));
			muestraL2.setFont(new Font(String.valueOf(listaFuente.getSelectedValue()), listaEstilo.getSelectedIndex(), Integer.parseInt(String.valueOf(listaTamaño.getSelectedValue()))));
		}
	}

	private void aceptarBactionPerformed(ActionEvent e) {
		textarea.setFont(new Font(String.valueOf(listaFuente.getSelectedValue()), listaEstilo.getSelectedIndex(), Integer.parseInt(String.valueOf(listaTamaño.getSelectedValue()))));
		dispose();
		dispose();
	}

	private void cancelarBactionPerformed(ActionEvent e) {
		dispose();
	}

	private JLabel fuenteL, estiloL, tamañoL;
	private JLabel muestraL1, muestraL2;
	private JTextField fuenteF, estiloF, tamañoF;
	private JList listaFuente, listaEstilo, listaTamaño;
	private final String[] Sfuente = {"Arial", "Book Antiqua","Bell MT","Bodoni MT","Book Antiqua", "Calibri", "Courier", "Elephant", "Times New Roman"};
	private final String[] Sestilo = {"Normal", "Negrita", "Cursiva"};
	private final String[] Stamaño = {"12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
	private JScrollPane scrollfuente;
	private JScrollPane scrollestilo;
	private JScrollPane scrolltamaño;
	private JSeparator separa1, separa2, separa3;
	private JButton aceptarB, cancelarB;

	JTextArea textarea;
}
