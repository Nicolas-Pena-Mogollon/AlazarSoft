package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelMostrarBorrarApuesta extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_LEER_INFORMACION_APUESTAS = "LEER_INFORMACION_APUESTAS";
	private final String COMMAND_BORRAR_INFORMACION_APUESTAS = "BORRAR_INFORMACION_APUESTAS";
	private JLabel etiquetaTipoApuesta;
	private JLabel etiquetaSede;
	private JButton botonLeerInformacionApuestas;
	private JButton botonBorrarInformacionApuestas;
	private JComboBox<String> comboSede;
	private JComboBox<String> comboTipoApuesta;
	private JTable tablaInformacionApuestas;
	private DefaultTableModel modeloTablaApuestas;
	private JScrollPane scrollTablaInformacionApuestas;
	private JPanel panelBotones;
	private JPanel panelCombos;

	public PanelMostrarBorrarApuesta() {
		setBorder(new TitledBorder("Información y borrado de apuestas"));
		setLayout(new BorderLayout());

		etiquetaSede = new JLabel("Sede");
		etiquetaTipoApuesta = new JLabel("Tipo de apuesta");

		comboSede = new JComboBox<String>();

		comboTipoApuesta = new JComboBox<String>();
		comboTipoApuesta.addItem("Seleccione el tipo de apuesta");
		comboTipoApuesta.addItem("Baloto");
		comboTipoApuesta.addItem("Super Astro");
		comboTipoApuesta.addItem("Fútbol");

		panelCombos = new JPanel(new GridLayout(1, 4));
		panelCombos.add(etiquetaSede);
		panelCombos.add(comboSede);
		panelCombos.add(etiquetaTipoApuesta);
		panelCombos.add(comboTipoApuesta);

		modeloTablaApuestas = new DefaultTableModel();
		modeloTablaApuestas.fireTableStructureChanged();
		tablaInformacionApuestas = new JTable(modeloTablaApuestas);

		modeloTablaApuestas.addColumn("Fecha");
		modeloTablaApuestas.addColumn("Cédula");
		modeloTablaApuestas.addColumn("Datos de apuesta");
		modeloTablaApuestas.addColumn("Valor");
		tablaInformacionApuestas.setDefaultEditor(tablaInformacionApuestas.getColumnClass(0), null);

		scrollTablaInformacionApuestas = new JScrollPane(tablaInformacionApuestas);

		botonLeerInformacionApuestas = new JButton("Mostrar información");
		botonLeerInformacionApuestas.setActionCommand(COMMAND_LEER_INFORMACION_APUESTAS);

		botonBorrarInformacionApuestas = new JButton("Borrar apuesta");
		botonBorrarInformacionApuestas.setActionCommand(COMMAND_BORRAR_INFORMACION_APUESTAS);

		panelBotones = new JPanel(new GridLayout(1, 2));
		panelBotones.add(botonLeerInformacionApuestas);
		panelBotones.add(botonBorrarInformacionApuestas);

		this.add(panelCombos, BorderLayout.PAGE_START);
		this.add(scrollTablaInformacionApuestas, BorderLayout.CENTER);
		this.add(panelBotones, BorderLayout.PAGE_END);
	}

	public void llenarComboSedes(String[] data) {
		comboSede.removeAllItems();
		comboSede.addItem("Seleccione la sede");
		for (int i = 0; i < data.length; i++) {
			comboSede.addItem(data[i]);
		}
	}

	public void actualizarTablaApuestas(String[][] data) {
		modeloTablaApuestas.setRowCount(0);
		for (int i = 0; i < data.length; i++) {
			modeloTablaApuestas.addRow(data[i]);
		}
	}

	public boolean verificarDatos() {
		if (!this.comboSede.getSelectedItem().equals("Seleccione la sede")
				&& !this.comboTipoApuesta.getSelectedItem().equals("Seleccione el tipo de apuesta")) {
			return true;

		} else {
			return false;

		}
	}

	public int verificarDatosTabla() {
		if (this.tablaInformacionApuestas.getSelectedRows().length == 1) {
			String[] cont = String
					.valueOf(
							this.tablaInformacionApuestas.getValueAt(this.tablaInformacionApuestas.getSelectedRow(), 2))
					.split("-");
			if (cont.length == 6 && comboTipoApuesta.getSelectedItem().equals("Baloto")) {
				return 1;
			} else if (cont.length == 5 && comboTipoApuesta.getSelectedItem().equals("Super Astro")) {
				return 1;
			} else if (cont.length == 3 && comboTipoApuesta.getSelectedItem().equals("Fútbol")) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}

	public String[] obtenerDatosTabla() {
		String[] salida = new String[4];
		salida[0] = "0";
		if (this.tablaInformacionApuestas.getSelectedRows().length == 1) {
			salida[1] = String.valueOf(
					this.tablaInformacionApuestas.getValueAt(this.tablaInformacionApuestas.getSelectedRow(), 0));
			salida[2] = String.valueOf(
					this.tablaInformacionApuestas.getValueAt(this.tablaInformacionApuestas.getSelectedRow(), 1));
			salida[3] = "Se ha borrado exitosamente la apuesta";
		} else {
			salida[0] = "1";
			salida[1] = "Seleccione una sola apuesta";
		}
		return salida;
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

	/**
	 * @return the comboSede
	 */
	public JComboBox<String> getComboSede() {
		return comboSede;
	}

	/**
	 * @param comboSede the comboSede to set
	 */
	public void setComboSede(JComboBox<String> comboSede) {
		this.comboSede = comboSede;
	}

	/**
	 * @return the comboTipoApuesta
	 */
	public JComboBox<String> getComboTipoApuesta() {
		return comboTipoApuesta;
	}

	/**
	 * @param comboTipoApuesta the comboTipoApuesta to set
	 */
	public void setComboTipoApuesta(JComboBox<String> comboTipoApuesta) {
		this.comboTipoApuesta = comboTipoApuesta;
	}

}
