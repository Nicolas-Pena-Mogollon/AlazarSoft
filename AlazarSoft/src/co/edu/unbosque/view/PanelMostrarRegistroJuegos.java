package co.edu.unbosque.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelMostrarRegistroJuegos extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_LEER_JUEGOS = "LEER_JUEGOS";
	private JButton botonLeer;
	private JTable tabla;
	private DefaultTableModel modeloTabla;
	private JScrollPane scroll;

	public PanelMostrarRegistroJuegos() {
		setBorder(new TitledBorder("Mostrar información juegos"));
		setLayout(new BorderLayout());
		botonLeer = new JButton();

		modeloTabla = new DefaultTableModel();
		modeloTabla.fireTableStructureChanged();
		tabla = new JTable(modeloTabla);
		tabla.setEnabled(false);

		modeloTabla.addColumn("NickName");
		modeloTabla.addColumn("Nombre del juego");
		modeloTabla.addColumn("Puntos");

		scroll = new JScrollPane(tabla);

		botonLeer = new JButton("Leer Juegos");
		botonLeer.setActionCommand(COMMAND_LEER_JUEGOS);

		this.add(scroll, BorderLayout.CENTER);
		this.add(botonLeer, BorderLayout.PAGE_END);
	}

	public void actualizarTablaMostrarJuegos(String[][] data) {
		modeloTabla.setRowCount(0);
		for (int i = 0; i < data.length; i++) {
			modeloTabla.addRow(data[i]);
		}
	}

	public JButton getBotonLeer() {
		return botonLeer;
	}

	public void setBotonLeer(JButton botonLeer) {
		this.botonLeer = botonLeer;
	}

	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
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

	public String getCOMMAND_LEER_JUEGOS() {
		return COMMAND_LEER_JUEGOS;
	}

}
