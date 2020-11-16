package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelSedeCrear extends JPanel {

	private static final long serialVersionUID = 1L;
	private final String COMMAND_GUARDAR = "GUARDAR_DATOS_SEDE";
	private JLabel etiquetaNombreSede;
	private JLabel etiquetaNumeroEmpleado;
	private JTextField campoTextoNombreSede;
	private JTextField campoTextoNumeroEmpleado;
	private JButton botonSede;
	private JPanel panelSede;

	public PanelSedeCrear() {

		setBorder(new TitledBorder("Ingreso de datos de la sede"));
		setLayout(new BorderLayout());
		panelSede = new JPanel();
		panelSede.setLayout(new GridLayout(2, 2));

		etiquetaNombreSede = new JLabel("Nombre de la sede: ");
		etiquetaNumeroEmpleado = new JLabel("Número de empleados: ");

		campoTextoNombreSede = new JTextField();
		campoTextoNumeroEmpleado = new JTextField();

		panelSede.add(etiquetaNombreSede);
		panelSede.add(campoTextoNombreSede);

		panelSede.add(etiquetaNumeroEmpleado);
		panelSede.add(campoTextoNumeroEmpleado);

		botonSede = new JButton("Crear Registro");
		botonSede.setActionCommand(COMMAND_GUARDAR);

		this.add(panelSede, BorderLayout.CENTER);
		this.add(botonSede, BorderLayout.PAGE_END);

	}

	public String[] verificarEntradasIngresoSedes() {
		String[] salida = new String[4];
		salida[0] = "0";
		if (!campoTextoNombreSede.getText().equals("") && !campoTextoNumeroEmpleado.getText().equals("")) {
			String ubicacion = campoTextoNombreSede.getText();
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
		campoTextoNombreSede.setText("");
		campoTextoNumeroEmpleado.setText("");
	}

	public JLabel getEtiquetaNombreSede() {
		return etiquetaNombreSede;
	}

	public void setEtiquetaNombreSede(JLabel etiquetaNombreSede) {
		this.etiquetaNombreSede = etiquetaNombreSede;
	}

	public JLabel getEtiquetaNumeroEmpleado() {
		return etiquetaNumeroEmpleado;
	}

	public void setEtiquetaNumeroEmpleado(JLabel etiquetaNumeroEmpleado) {
		this.etiquetaNumeroEmpleado = etiquetaNumeroEmpleado;
	}

	public JTextField getCampoTextoNombreSede() {
		return campoTextoNombreSede;
	}

	public void setCampoTextoNombreSede(JTextField campoTextoNombreSede) {
		this.campoTextoNombreSede = campoTextoNombreSede;
	}

	public JTextField getCampoTextoNumeroEmpleado() {
		return campoTextoNumeroEmpleado;
	}

	public void setCampoTextoNumeroEmpleado(JTextField campoTextoNumeroEmpleado) {
		this.campoTextoNumeroEmpleado = campoTextoNumeroEmpleado;
	}

	public JButton getBotonSede() {
		return botonSede;
	}

	public void setBotonSede(JButton botonSede) {
		this.botonSede = botonSede;
	}

	public JPanel getPanelSede() {
		return panelSede;
	}

	public void setPanelSede(JPanel panelSede) {
		this.panelSede = panelSede;
	}

	public String getCOMMAND_GUARDAR() {
		return COMMAND_GUARDAR;
	}
	
	
}
