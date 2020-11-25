package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Clase PanelIngresoCasaApuestas
 */

public class PanelIngresoCasaApuestas extends JPanel {

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

	/**
	 * Constructor con inicialización de atributos
	 */

	public PanelIngresoCasaApuestas() {

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

	/**
	 * Verifica los datos de entrada y retorna un String unidimensional con los
	 * valores correspondientes. Revisa que los datos de ingreso sean correctos
	 * 
	 * @return salida
	 */

	public String[] verificarEntradasIngresoDatosJuegos() {
		String[] salida = new String[5];
		salida[0] = "0";
		if (!campoTextoNombreCasaApuestas.getText().equals("") || !campoTextoNumeroSedes.getText().equals("")
				|| !campoTextoPresupuesto.getText().equals("")) {

			String nombre = campoTextoNombreCasaApuestas.getText();
			String numSedes = campoTextoNumeroSedes.getText();
			String presupuesto = campoTextoPresupuesto.getText();
			try {
				if (!presupuesto.equals("") && !numSedes.equals("")) {
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
				} else if (presupuesto.equals("") && numSedes.equals("")) {
					salida[1] = nombre;
					salida[2] = "-1";
					salida[3] = "-1";
					salida[4] = "Configuración guardada";
				} else if (!presupuesto.equals("")) {
					if (Integer.parseInt(presupuesto) <= 0) {
						salida[0] = "1";
						salida[1] = "Valor del número de sedes inválido";
					} else {
						salida[1] = nombre;
						salida[2] = "-1";
						salida[3] = presupuesto;
						salida[4] = "Configuración guardada";
					}
				} else {
					if (Long.parseLong(numSedes) <= 0) {
						salida[0] = "1";
						salida[1] = "Valor del número de sedes inválido";
					} else {
						salida[1] = nombre;
						salida[2] = numSedes;
						salida[3] = "-1";
						salida[4] = "Configuración guardada";
					}
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

	/**
	 * Limpia los campos de texto y borra los valores que tengan en la interfaz
	 */

	public void borrarCamposIngresoCasaApuestas() {
		this.campoTextoNombreCasaApuestas.setText("");
		this.campoTextoNumeroSedes.setText("");
		this.campoTextoPresupuesto.setText("");
	}

	public JTextField getCampoTextoNombreCasaApuestas() {
		return campoTextoNombreCasaApuestas;
	}

	public void setCampoTextoNombreCasaApuestas(JTextField campoTextoNombreCasaApuestas) {
		this.campoTextoNombreCasaApuestas = campoTextoNombreCasaApuestas;
	}

	public JTextField getCampoTextoNumeroSedes() {
		return campoTextoNumeroSedes;
	}

	public void setCampoTextoNumeroSedes(JTextField campoTextoNumeroSedes) {
		this.campoTextoNumeroSedes = campoTextoNumeroSedes;
	}

	public JTextField getCampoTextoPresupuesto() {
		return campoTextoPresupuesto;
	}

	public void setCampoTextoPresupuesto(JTextField campoTextoPresupuesto) {
		this.campoTextoPresupuesto = campoTextoPresupuesto;
	}

	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	public void setBotonGuardar(JButton botonGuardar) {
		this.botonGuardar = botonGuardar;
	}

	public String getCOMMAND_INGRESAR() {
		return COMMAND_INGRESAR;
	}

}
