package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Clase PanelInformacionApostadores
 */

public class PanelInformacionApostadores extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_LEER_INFORMACION_APOSTADORES = "LEER";
	private JButton botonLeerInformacionApostadores;
	private JTable tablaInformacionApostadores;
	private DefaultTableModel modeloTablaApostadores;
	private JScrollPane scrollTablaInformacionApostadores;

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelInformacionApostadores() {
		setBorder(new TitledBorder("Información apostadores"));
		setLayout(new BorderLayout());

		modeloTablaApostadores = new DefaultTableModel();
		modeloTablaApostadores.fireTableStructureChanged();
		tablaInformacionApostadores = new JTable(modeloTablaApostadores);
		tablaInformacionApostadores.setEnabled(false);

		modeloTablaApostadores.addColumn("Cédula");
		modeloTablaApostadores.addColumn("Nombre");
		modeloTablaApostadores.addColumn("Celular");
		modeloTablaApostadores.addColumn("Dirección");
		modeloTablaApostadores.addColumn("Sede");

		scrollTablaInformacionApostadores = new JScrollPane(tablaInformacionApostadores);

		botonLeerInformacionApostadores = new JButton("Actualizar tabla");
		botonLeerInformacionApostadores.setActionCommand(COMMAND_LEER_INFORMACION_APOSTADORES);

		this.add(scrollTablaInformacionApostadores, BorderLayout.CENTER);
		this.add(botonLeerInformacionApostadores, BorderLayout.PAGE_END);

	}

	/**
	 * Toma un array bidimensional con los datos de los apostadores y los agrega a
	 * la tabla
	 * 
	 * @param data
	 */
	public void actualizarTablaApostadores(String[][] data) {
		modeloTablaApostadores.setRowCount(0);
		for (int i = 0; i < data.length; i++) {
			modeloTablaApostadores.addRow(data[i]);
		}
	}

	/**
	 * @return the botonLeerInformacionApostadores
	 */
	public JButton getBotonLeerInformacionApostadores() {
		return botonLeerInformacionApostadores;
	}

	/**
	 * @param botonLeerInformacionApostadores the botonLeerInformacionApostadores to
	 *                                        set
	 */
	public void setBotonLeerInformacionApostadores(JButton botonLeerInformacionApostadores) {
		this.botonLeerInformacionApostadores = botonLeerInformacionApostadores;
	}

	/**
	 * @return the tablaInformacionApostadores
	 */
	public JTable getTablaInformacionApostadores() {
		return tablaInformacionApostadores;
	}

	/**
	 * @param tablaInformacionApostadores the tablaInformacionApostadores to set
	 */
	public void setTablaInformacionApostadores(JTable tablaInformacionApostadores) {
		this.tablaInformacionApostadores = tablaInformacionApostadores;
	}

	/**
	 * @return the cOMMAND_LEER_INFORMACION_APOSTADORES
	 */
	public String getCOMMAND_LEER_INFORMACION_APOSTADORES() {
		return COMMAND_LEER_INFORMACION_APOSTADORES;
	}

}
