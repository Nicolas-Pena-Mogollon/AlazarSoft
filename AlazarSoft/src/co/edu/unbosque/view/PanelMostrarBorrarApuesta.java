package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelMostrarBorrarApuesta extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_LEER_INFORMACION_APUESTAS = "LEER";
	private final String COMMAND_BORRAR_INFORMACION_APUESTAS = "LEER";
	private JButton botonLeerInformacionApuestas;
	private JButton botonBorrarInformacionApuestas;
	private JTable tablaInformacionApuestas;
	private DefaultTableModel modeloTablaApuestas;
	private JScrollPane scrollTablaInformacionApuestas;
	private JPanel panelBotones;

	public PanelMostrarBorrarApuesta() {
		setBorder(new TitledBorder("Información y borrado de apuestas"));
		setLayout(new BorderLayout());

		modeloTablaApuestas = new DefaultTableModel();
		modeloTablaApuestas.fireTableStructureChanged();
		tablaInformacionApuestas = new JTable(modeloTablaApuestas);
		tablaInformacionApuestas.setEnabled(false);

		modeloTablaApuestas.addColumn("Fecha");
		modeloTablaApuestas.addColumn("Sede");
		modeloTablaApuestas.addColumn("Cédula");
		modeloTablaApuestas.addColumn("Tipo");
		modeloTablaApuestas.addColumn("Valor");

		scrollTablaInformacionApuestas = new JScrollPane(tablaInformacionApuestas);

		botonLeerInformacionApuestas = new JButton("Mostrar información");
		botonLeerInformacionApuestas.setActionCommand(COMMAND_LEER_INFORMACION_APUESTAS);

		botonBorrarInformacionApuestas = new JButton("Borrar apuesta");
		botonBorrarInformacionApuestas.setActionCommand(COMMAND_BORRAR_INFORMACION_APUESTAS);

		panelBotones = new JPanel(new GridLayout(1, 2));
		panelBotones.add(botonLeerInformacionApuestas);
		panelBotones.add(botonBorrarInformacionApuestas);

		this.add(scrollTablaInformacionApuestas, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.PAGE_END);

	}

	public void actualizarTablaApuestas(String[][] data) {
		modeloTablaApuestas.setRowCount(0);
		for (int i = 0; i < data.length; i++) {
			modeloTablaApuestas.addRow(data[i]);
		}
	}

	/**
	 * @return the botonLeerInformacionApuestas
	 */
	public JButton getBotonLeerInformacionApuestas() {
		return botonLeerInformacionApuestas;
	}

	/**
	 * @param botonLeerInformacionApuestas the botonLeerInformacionApuestas to set
	 */
	public void setBotonLeerInformacionApuestas(JButton botonLeerInformacionApuestas) {
		this.botonLeerInformacionApuestas = botonLeerInformacionApuestas;
	}

	/**
	 * @return the botonBorrarInformacionApuestas
	 */
	public JButton getBotonBorrarInformacionApuestas() {
		return botonBorrarInformacionApuestas;
	}

	/**
	 * @param botonBorrarInformacionApuestas the botonBorrarInformacionApuestas to
	 *                                       set
	 */
	public void setBotonBorrarInformacionApuestas(JButton botonBorrarInformacionApuestas) {
		this.botonBorrarInformacionApuestas = botonBorrarInformacionApuestas;
	}

	/**
	 * @return the tablaInformacionApuestas
	 */
	public JTable getTablaInformacionApuestas() {
		return tablaInformacionApuestas;
	}

	/**
	 * @param tablaInformacionApuestas the tablaInformacionApuestas to set
	 */
	public void setTablaInformacionApuestas(JTable tablaInformacionApuestas) {
		this.tablaInformacionApuestas = tablaInformacionApuestas;
	}

	/**
	 * @return the cOMMAND_LEER_INFORMACION_APUESTAS
	 */
	public String getCOMMAND_LEER_INFORMACION_APUESTAS() {
		return COMMAND_LEER_INFORMACION_APUESTAS;
	}

	/**
	 * @return the cOMMAND_BORRAR_INFORMACION_APUESTAS
	 */
	public String getCOMMAND_BORRAR_INFORMACION_APUESTAS() {
		return COMMAND_BORRAR_INFORMACION_APUESTAS;
	}

}
