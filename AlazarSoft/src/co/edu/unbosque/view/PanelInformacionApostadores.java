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
	private final String COMMAND_LEER_INFORMACION_APOSTADORES = "LEER";
	private JButton botonLeerInformacionApostadores;
	private JTable tablaInformacionApostadores;
	private DefaultTableModel modeloTablaApostadores;
	private JScrollPane scrollTabalaInformacionApostadores;

	public PanelInformacionApostadores() {
		setBorder(new TitledBorder("Información Apostadores"));
		setLayout(new BorderLayout());

		modeloTablaApostadores = new DefaultTableModel();
		modeloTablaApostadores.fireTableStructureChanged();
		tablaInformacionApostadores = new JTable(modeloTablaApostadores);
		tablaInformacionApostadores.setEnabled(false);

		modeloTablaApostadores.addColumn("Cédula");
		modeloTablaApostadores.addColumn("Nombre");
		modeloTablaApostadores.addColumn("Dirección");
		modeloTablaApostadores.addColumn("Celular");
		modeloTablaApostadores.addColumn("Sede");

		scrollTabalaInformacionApostadores = new JScrollPane(tablaInformacionApostadores);

		botonLeerInformacionApostadores = new JButton();
		botonLeerInformacionApostadores = new JButton("Mostrar información");
		botonLeerInformacionApostadores.setActionCommand(COMMAND_LEER_INFORMACION_APOSTADORES);

		this.add(scrollTabalaInformacionApostadores, BorderLayout.CENTER);
		this.add(botonLeerInformacionApostadores, BorderLayout.PAGE_END);

	}

	public void actualizarTabla(String[][] data) {
		modeloTablaApostadores.setRowCount(0);
		for (int i = 0; i < data.length; i++) {
			modeloTablaApostadores.addRow(data[i]);
		}
	}

	public JButton getBotonLeerInformacionApostadores() {
		return botonLeerInformacionApostadores;
	}

	public void setBotonLeerInformacionApostadores(JButton botonLeerInformacionApostadores) {
		this.botonLeerInformacionApostadores = botonLeerInformacionApostadores;
	}

	public JTable getTablaInformacionApostadores() {
		return tablaInformacionApostadores;
	}

	public void setTablaInformacionApostadores(JTable tablaInformacionApostadores) {
		this.tablaInformacionApostadores = tablaInformacionApostadores;
	}

	public String getCOMMAND_LEER_INFORMACION_APOSTADORES() {
		return COMMAND_LEER_INFORMACION_APOSTADORES;
	}

}
