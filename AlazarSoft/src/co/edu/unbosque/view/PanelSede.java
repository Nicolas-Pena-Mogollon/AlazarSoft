package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelSede extends JPanel{

	private static final long serialVersionUID = 1L;
	private final String COMMAND_INGRESAR = "GUARDAR_DATOS_CASA_APUESTAS";
	private JLabel etiquetaNombreCasaApuestas;
	private JLabel etiquetNumeroSedes;
	private JLabel etiquetaPresupuesto;
	private JTextField campoTextoNombreCasaApuestas;
	private JTextField campoTextoNumeroSedes;
	private JTextField campoTextoPresupuesto;
	private JButton botonGuardar;
	private JPanel panelIngreso;

	public PanelSede() {

		setBorder(new TitledBorder("Ingreso de los datos de la casa de apuestas"));
		setLayout(new BorderLayout());
		panelIngreso = new JPanel();
		panelIngreso.setLayout(new GridLayout(4, 2));

		etiquetaNombreCasaApuestas = new JLabel("Nombre");
		etiquetNumeroSedes = new JLabel("Número de sedes");
		etiquetaPresupuesto = new JLabel("Presupuesto total");

		campoTextoNombreCasaApuestas = new JTextField();
		campoTextoNumeroSedes = new JTextField();
		campoTextoPresupuesto = new JTextField();

		panelIngreso.add(etiquetaNombreCasaApuestas);
		panelIngreso.add(campoTextoNombreCasaApuestas);

		panelIngreso.add(etiquetNumeroSedes);
		panelIngreso.add(campoTextoNumeroSedes);

		panelIngreso.add(etiquetaPresupuesto);
		panelIngreso.add(campoTextoPresupuesto);

		botonGuardar = new JButton("Guardar");
		botonGuardar.setActionCommand(COMMAND_INGRESAR);

		this.add(panelIngreso, BorderLayout.CENTER);
		this.add(botonGuardar, BorderLayout.PAGE_END);

	}

	public String[] verificarEntradasIngresoDatosJuegos() {
		String[] salida = new String[5];
		salida[0] = "0";
		if (!campoTextoNombreCasaApuestas.getText().equals("") && !campoTextoNumeroSedes.getText().equals("")
				&& !campoTextoPresupuesto.getText().equals("")) {
			String nombre = campoTextoNombreCasaApuestas.getText();
			String numSedes = campoTextoNumeroSedes.getText();
			String presupuesto = campoTextoPresupuesto.getText();
			try {
				if (Integer.parseInt(presupuesto) <= 0) {
					salida[0] = "1";
					salida[1] = "Valor de presupuesto inválido";
				} else if (Long.parseLong(numSedes) <= 0) {
					salida[0] = "1";
					salida[1] = "Valor del número de sedes inválido";
				} else {
					salida[1] = nombre;
					salida[2] = numSedes;
					salida[3] = presupuesto;
					salida[4] = "Configuración guardada";
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
}
