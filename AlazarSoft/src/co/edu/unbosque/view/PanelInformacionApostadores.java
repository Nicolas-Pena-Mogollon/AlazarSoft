package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelInformacionApostadores extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_LEER = "LEER";
	private JButton botonLeer;
	private JTable tablaApostadores;
	private DefaultTableModel modeloTablaApostadores;
	private JScrollPane scroll;

	public PanelInformacionApostadores() {
		setBorder(new TitledBorder("Información Apostadores"));
		setLayout(new BorderLayout());

		modeloTablaApostadores = new DefaultTableModel();
		modeloTablaApostadores.fireTableStructureChanged();
		tablaApostadores = new JTable(modeloTablaApostadores);
		tablaApostadores.setEnabled(false);

		modeloTablaApostadores.addColumn("Cédula");
		modeloTablaApostadores.addColumn("Nombre");
		modeloTablaApostadores.addColumn("Dirección");
		modeloTablaApostadores.addColumn("Celular");
		modeloTablaApostadores.addColumn("Sede");

		scroll = new JScrollPane(tablaApostadores);

		botonLeer = new JButton();
		botonLeer = new JButton("Mostrar información");
		botonLeer.setActionCommand(COMMAND_LEER);

		this.add(scroll, BorderLayout.CENTER);
		this.add(botonLeer, BorderLayout.PAGE_END);

	}

	public void actualizarTabla(String[][] data) {
		modeloTablaApostadores.setRowCount(0);
		for (int i = 0; i < data.length; i++) {
			modeloTablaApostadores.addRow(data[i]);
		}
	}

	public JButton getBotonLeer() {
		return botonLeer;
	}

	public void setBotonLeer(JButton botonLeer) {
		this.botonLeer = botonLeer;
	}

	public JTable getTabla() {
		return tablaApostadores;
	}

	public void setTabla(JTable tabla) {
		this.tablaApostadores = tabla;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTablaApostadores;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTablaApostadores = modeloTabla;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCOMMAND_LEER() {
		return COMMAND_LEER;
	}

}
