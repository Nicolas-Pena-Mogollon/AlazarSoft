package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelSedeCrear extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_GUARDAR = "GUARDAR_DATOS_SEDE";
	private JLabel etiquetaNombreSede;
	private JLabel etiquetaNumeroEmpleado;
	private JComboBox<String> comboNombreSede;
	private JTextField campoTextoNumeroEmpleado;
	private JButton botonSede;
	private JPanel panelSede;

	public PanelSedeCrear() {

		setBorder(new TitledBorder("Ingreso de datos de la sede"));
		setLayout(new BorderLayout());
		panelSede = new JPanel();
		panelSede.setLayout(new GridLayout(2, 2));

		etiquetaNombreSede = new JLabel("Ubicación de la Sede: ");
		etiquetaNumeroEmpleado = new JLabel("Número de empleados: ");

		comboNombreSede = new JComboBox<String>();
		comboNombreSede.addItem("Seleccione");
		comboNombreSede.addItem("Antonio Nariño");
		comboNombreSede.addItem("Barrios Unidos");
		comboNombreSede.addItem("Bosa");
		comboNombreSede.addItem("Chapinero");
		comboNombreSede.addItem("Ciudad Bolívar");
		comboNombreSede.addItem("Engativá");
		comboNombreSede.addItem("Fontibón");
		comboNombreSede.addItem("Kennedy");
		comboNombreSede.addItem("La Candelaria");
		comboNombreSede.addItem("Los Mártires");
		comboNombreSede.addItem("Puente Aranda");
		comboNombreSede.addItem("Rafael Uribe Uribe");
		comboNombreSede.addItem("San Cristóbal");
		comboNombreSede.addItem("Santa Fe");
		comboNombreSede.addItem("Suba");
		comboNombreSede.addItem("Sumapaz");
		comboNombreSede.addItem("Teusaquillo");
		comboNombreSede.addItem("Tunjuelito");
		comboNombreSede.addItem("Usaquén");
		comboNombreSede.addItem("Usme");

		campoTextoNumeroEmpleado = new JTextField();

		panelSede.add(etiquetaNombreSede);
		panelSede.add(comboNombreSede);

		panelSede.add(etiquetaNumeroEmpleado);
		panelSede.add(campoTextoNumeroEmpleado);

		botonSede = new JButton("Crear Registro");
		botonSede.setActionCommand(COMMAND_GUARDAR);

		this.add(panelSede, BorderLayout.PAGE_START);
		this.add(botonSede, BorderLayout.PAGE_END);

	}

	public String[] verificarEntradasIngresoSedes() {
		String[] salida = new String[4];
		salida[0] = "0";
		if (!comboNombreSede.getSelectedItem().equals("Seleccione") && !campoTextoNumeroEmpleado.getText().equals("")) {
			String ubicacion = String.valueOf(comboNombreSede.getSelectedItem());
			String numEmpleados = campoTextoNumeroEmpleado.getText();
			try {
				if (Integer.parseInt(numEmpleados) <= 0) {
					salida[0] = "1";
					salida[1] = "Valor de presupuesto inválido";
				} else {
					salida[1] = ubicacion;
					salida[2] = numEmpleados;
					salida[3] = "Configuración guardada";
				}
			} catch (NumberFormatException e) {
				salida[0] = "1";
				salida[1] = "Valor numérico inválido";
			}
		} else {
			salida[0] = "1";
			salida[1] = "Los campos deben ser completados";
		}
		return salida;
	}

	public void borrarCamposTxt() {
		comboNombreSede.setSelectedIndex(0);
		campoTextoNumeroEmpleado.setText("");
	}

	/**
	 * @return the comboNombreSede
	 */
	public JComboBox<String> getComboNombreSede() {
		return comboNombreSede;
	}

	/**
	 * @param comboNombreSede the comboNombreSede to set
	 */
	public void setComboNombreSede(JComboBox<String> comboNombreSede) {
		this.comboNombreSede = comboNombreSede;
	}

	/**
	 * @return the campoTextoNumeroEmpleado
	 */
	public JTextField getCampoTextoNumeroEmpleado() {
		return campoTextoNumeroEmpleado;
	}

	/**
	 * @param campoTextoNumeroEmpleado the campoTextoNumeroEmpleado to set
	 */
	public void setCampoTextoNumeroEmpleado(JTextField campoTextoNumeroEmpleado) {
		this.campoTextoNumeroEmpleado = campoTextoNumeroEmpleado;
	}

	/**
	 * @return the botonSede
	 */
	public JButton getBotonSede() {
		return botonSede;
	}

	/**
	 * @param botonSede the botonSede to set
	 */
	public void setBotonSede(JButton botonSede) {
		this.botonSede = botonSede;
	}

	/**
	 * @return the cOMMAND_GUARDAR
	 */
	public String getCOMMAND_GUARDAR() {
		return COMMAND_GUARDAR;
	}

}
